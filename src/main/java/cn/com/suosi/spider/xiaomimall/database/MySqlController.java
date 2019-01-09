package cn.com.suosi.spider.xiaomimall.database;

import cn.com.suosi.spider.xiaomimall.bean.Product;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class MySqlController {

    static DataSource dataSource = MyDataSource.getDataSource("jdbc:mysql://localhost:3306/spider?useUnicode=true&characterEncoding=utf-8&useSSL=false");
    static QueryRunner queryRunner = new QueryRunner(dataSource);

    public static void executeInsert(List<Product> productList) throws SQLException {

        Object[][] params = new Object[productList.size()][7];

        for (int i = 0; i < params.length; i++) {
            params[i][0] = productList.get(i).getProduct_id();
            params[i][1] = productList.get(i).getProduct_url();
            params[i][2] = productList.get(i).getName_edition();
            params[i][3] = productList.get(i).getPrice_min();
            params[i][4] = productList.get(i).getPrice_max();
            params[i][5] = productList.get(i).getComment_number();
            params[i][6] = productList.get(i).getComment();
        }

        queryRunner.batch("insert into xiaomimall (product_id, product_url, name_edition, price_min, price_max, comment_number, comment)"
                + "values (?,?,?,?,?,?,?)", params);

        for (Product product : productList) {
            System.out.println("成功插入数据：");
            System.out.println(product);
        }

        System.out.println("数据量：" + productList.size());
    }
}
