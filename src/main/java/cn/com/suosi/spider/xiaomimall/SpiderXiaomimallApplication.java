package cn.com.suosi.spider.xiaomimall;

import cn.com.suosi.spider.xiaomimall.bean.Product;
import cn.com.suosi.spider.xiaomimall.constant.SysConstant;
import cn.com.suosi.spider.xiaomimall.database.MySqlController;
import cn.com.suosi.spider.xiaomimall.parse.JsonParse;
import cn.com.suosi.spider.xiaomimall.parse.SearchUrlParse;
import cn.com.suosi.spider.xiaomimall.parse.UrlFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpiderXiaomimallApplication {

    public static void main(String[] args) throws Exception {


        /**------------------------------更新所有商品id-------------------------------*/

        // 所有商品url
        List<String> productUrls = UrlFactory.getProductUrl(SysConstant.BASE_URL);

        // 所有商品id
        List<String> productIds1 = new ArrayList<>();

        for (String producturl : productUrls) {
            String productId = SearchUrlParse.getProductId(producturl);
            productIds1.add(productId);
        }

        // 去重
        List<String> productIds2 = productIds1.stream().distinct().collect(Collectors.toList());


        /**------------------------------更新所有商品信息------------------------------*/

        // 所有商品id，常量PRODUCT_IDS
        List<String> productIds = SysConstant.PRODUCT_IDS;

        // 所有商品信息 + 评论
        List<Product> productInfoLists = new ArrayList<>();

        for (String productid : productIds2) {

            List<Product> productInfoList = new ArrayList<>();

            if (productid != null) {

                // 商品信息
                String infojsonUrl = "https://api.order.mi.com/product/get?product_id=" + productid;

                String inforeferer = "https://item.mi.com/product/" + productid + ".html";

                productInfoList = JsonParse.productInfoJsonParse(infojsonUrl, inforeferer);

                // 商品评论
                String commentjsonUrl;

                if (productid.length() > 4) {
                    commentjsonUrl = "https://comment.huodong.mi.com/comment/entry/getSummary?goods_id=0&v_pid=" + productid;
                } else {
                    commentjsonUrl = "https://comment.huodong.mi.com/comment/entry/getSummary?goods_id=" + productid + "&v_pid=";
                }

                String commentreferer = "https://item.mi.com/comment/" + productid + ".html";

                Product productComment = JsonParse.commentJsonParse(commentjsonUrl, commentreferer);

                // 商品信息 + 评论
                for (Product productInfo : productInfoList) {
                    productInfo.setComment_number(productComment.getComment_number());
                    productInfo.setComment(productComment.getComment());
                }
            }

            productInfoLists.addAll(productInfoList);
        }

        // 存入数据库
        MySqlController.executeInsert(productInfoLists);


        /**----------------------------------检验是否更新所有商品id-------------------------------------*/
        System.out.println("productIds2 = " + productIds2);
        System.out.println(productIds2.size());
        System.out.println("productIds = " + productIds);
        System.out.println(productIds.size());
    }
}

