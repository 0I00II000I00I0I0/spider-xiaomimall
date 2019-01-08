package cn.com.suosi.spider.xiaomimall.parse;

import cn.com.suosi.spider.xiaomimall.bean.Product;
import cn.com.suosi.spider.xiaomimall.common.HttpClientUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParse {

    // 解析infojson，获取商品信息productInfo
    public static List<Product> productInfoJsonParse(String url, String referer) throws IOException {

        // 获取json
        HttpResponse response = HttpClientUtil.getProductHtml(url, referer);
        String entity = EntityUtils.toString(response.getEntity());
        JSONObject infojson = JSON.parseObject(entity);

        // 获取data
        String data = infojson.getString("data");

        List<Product> productInfoList = new ArrayList<>();

        // 能够获取data，解析
        if (data != null) {

            JSONObject datajson = JSON.parseObject(data);

            // 获取data中的productid、name、list
            String product_id = datajson.getString("product_id");
            String name = datajson.getString("name");
            String list = datajson.getString("list");

            JSONArray listjson = JSON.parseArray(list);

            for (int i = 0; i < listjson.size(); i++) {

                // 获取list中的value、list
                String value = ((JSONObject) listjson.get(i)).getString("value");
                String list_list = ((JSONObject) listjson.get(i)).getString("list");

                // 能够获取list
                if (list_list != null) {

                    JSONArray list_listjson = JSON.parseArray(list_list);

                    for (int j = 0; j < list_listjson.size(); j++) {

                        Product productinfo = new Product();

                        // 获取list_list中的value、price
                        String value_value = ((JSONObject) list_listjson.get(j)).getString("value");
                        String pricemin = ((JSONObject) list_listjson.get(j)).getString("price_min");
                        String pricemax = ((JSONObject) list_listjson.get(j)).getString("market_price_max");
                        String name_edition = name + "+" + value + "+" + value_value;

                        // 封装
                        productinfo.setProduct_id(product_id);
                        productinfo.setProduct_url(referer);
                        productinfo.setName_edition(name_edition);
                        productinfo.setPrice_min(pricemin);
                        productinfo.setPrice_max(pricemax);

                        productInfoList.add(productinfo);
                    }
                } else {

                    Product productInfo = new Product();

                    // 获取list中的value、price
                    String pricemin = ((JSONObject) listjson.get(i)).getString("price_min");
                    String pricemax = ((JSONObject) listjson.get(i)).getString("market_price_max");
                    String name_edition = name + "+" + value;

                    productInfo.setProduct_id(product_id);
                    productInfo.setProduct_url(referer);
                    productInfo.setName_edition(name_edition);
                    productInfo.setPrice_min(pricemin);
                    productInfo.setPrice_max(pricemax);

                    productInfoList.add(productInfo);
                }
            }
        }

        // 不能获取data，测试发现获取商品信息失败，但是商品评论依然存在
        // else {
        //    Product productInfo = new Product();
        //    productInfo.setProduct_url(referer);
        //    productInfoList.add(productInfo);
        //}
        return productInfoList;
    }


    // 解析commentjson，获取商品评论productComment
    public static Product commentJsonParse(String referer, String url) throws IOException {

        // 获取json
        HttpResponse response = HttpClientUtil.getProductHtml(referer, url);
        String entity = EntityUtils.toString(response.getEntity());
        JSONObject infojson = JSON.parseObject(entity);

        // 获取data
        String data = infojson.getString("data");

        String comment_number;
        String comment;
        Product productComment = new Product();

        // 能够获取data，解析
        if (data != null) {

            JSONObject datajson = JSON.parseObject(data);

            //获取data中的total_count,comment_tags
            String total_count = datajson.getString("total_count");
            String comment_tags = datajson.getString("comment_tags");

            comment_number = total_count;
            comment = "";

            //  评论数不为零，获取评论详情（有的评论只有评论数没有评论详情）
            if (!comment_number.equals("0")) {

                JSONArray commentjson = JSON.parseArray(comment_tags);

                for (int i = 0; i < commentjson.size(); i++) {

                    // 获取comment_tags中的tags
                    String tag_name = ((JSONObject) commentjson.get(i)).getString("tag_name");
                    String profile_num = ((JSONObject) commentjson.get(i)).getString("profile_num");
                    comment = comment + tag_name + "（" + profile_num + "）";

                }
            }

            productComment.setComment_number(comment_number);
            productComment.setComment(comment);

            // 不能获取data，该商品暂无评论
        } else {
            comment_number = "0";
            comment = "";
            // comment = "该商品暂无评论";
            productComment.setComment_number(comment_number);
            productComment.setComment(comment);
        }
        return productComment;
    }
}
