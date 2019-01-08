package cn.com.suosi.spider.xiaomimall.database;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;


public class MyDataSource {

    public static DataSource getDataSource(String connectURI) {

        // 数据库驱动、url、账号、密码
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setUrl(connectURI);

        return dataSource;
    }
}
