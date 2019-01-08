package cn.com.suosi.spider.xiaomimall.parse;

import cn.com.suosi.spider.xiaomimall.common.HttpClientUtil;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class SearchUrlParse {

    // 解析二级分页，获取分页url
    public static List<String> getSearchUrl(String url) throws Exception {

        List<String> productUrls = new ArrayList<>();

        HttpResponse response = HttpClientUtil.getRawHtml(url);

        int StatusCode = response.getStatusLine().getStatusCode();

        if (StatusCode == 200 && response.getEntity() != null) {

            String entity = EntityUtils.toString(response.getEntity(), "utf-8");

            Document document = Jsoup.parse(entity);

            Elements elements = document.select("div[class=content]").select("h2").select("a");

            for (Element element : elements) {

                String productUrl = element.attr("href");

                if (!productUrl.contains("http")) {
                    productUrl = "https:" + productUrl;
                }

                productUrls.add(productUrl);
            }

            EntityUtils.consume(response.getEntity());
        } else {
            EntityUtils.consume(response.getEntity());
        }
        return productUrls;
    }


    // 解析productUrl，获取productId
    public static String getProductId(String url) throws Exception {

        String productId = null;

        //如果带有www.mi.com为商品展示页
        if (url.contains("www.mi.com")) {

            HttpResponse response = HttpClientUtil.getRawHtml(url);

            int StatusCode = response.getStatusLine().getStatusCode();

            if (StatusCode == 200 && response.getEntity() != null) {

                String entity = EntityUtils.toString(response.getEntity(), "utf-8");
                Document document = Jsoup.parse(entity);
                Elements elements = document.select("head").select("script");

                productId = String.valueOf(elements);

                // script中包含detail，可以得到id
                if (productId.contains("detail/")) {

                    productId = productId.substring(productId.indexOf("l/") + 2);
                    productId = productId.substring(0, productId.indexOf("')"));

                // script中没有商品的id，无法解析
                } else {
                    productId = null;
                }

                EntityUtils.consume(response.getEntity());
            } else {
                EntityUtils.consume(response.getEntity());
            }

            // 其他直接根据url可以得到id，如果url包含product
        } else if (url.contains("product/")) {

            productId = url.substring(url.indexOf("t/") + 2);
            productId = productId.substring(0, productId.indexOf("."));

            // 如果url包含com
        } else {

            productId = url.substring(url.indexOf("m/") + 2);
            productId = productId.substring(0, productId.indexOf("."));

        }
        return productId;
    }
}
