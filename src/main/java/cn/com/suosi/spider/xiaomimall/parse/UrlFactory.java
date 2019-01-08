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

public class UrlFactory {

    // 解析起始url，获取所有商品url
    public static List<String> getProductUrl(String url) throws Exception {

        List<String> productUrls = new ArrayList<>();

        HttpResponse response = HttpClientUtil.getRawHtml(url);

        int StatusCode = response.getStatusLine().getStatusCode();

        if (StatusCode == 200) {

            String entity = EntityUtils.toString(response.getEntity(), "utf-8");
            Document document = Jsoup.parse(entity);
            Elements elements = document.select("div[class=box-bd J_box-bd]")
                    .select("li").select("a[class=category-list-title]");

            for (Element element : elements) {

                // 筛选分页商品url
                String productUrl = element.attr("href");

                if (!productUrl.contains("http")) {
                    productUrl = "https:" + productUrl;
                }

                if (productUrl.contains("search") || productUrl.contains("list")) {

                    productUrls.addAll(SearchUrlParse.getSearchUrl(productUrl));

                } else {
                    productUrls.add(productUrl);
                }
            }

            EntityUtils.consume(response.getEntity());
        } else {
            EntityUtils.consume(response.getEntity());
        }
        return productUrls;
    }
}
