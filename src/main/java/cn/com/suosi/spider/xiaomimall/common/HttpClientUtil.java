package cn.com.suosi.spider.xiaomimall.common;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHttpResponse;

import java.io.IOException;

public class HttpClientUtil {

    // 获取默认url响应
    public static HttpResponse getRawHtml(String url) {

        HttpClient httpClient = HttpClients.createDefault();

        HttpGet getMethod = new HttpGet(url);

        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");

        try {
            response = httpClient.execute(getMethod);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

        return response;
    }

    // 获取producturl响应
    public static HttpResponse getProductHtml(String url, String referer) {

        HttpClient httpClient = HttpClients.createDefault();

        HttpGet getMethod = new HttpGet(url);

        getMethod.setHeader("Referer", referer);

        // 这些信息有没有都可以
        // getMethod.setHeader("accept", "*/*");
        // getMethod.setHeader("Accept-Encoding", "gzip, deflate, br");
        // getMethod.setHeader("Accept-Language", "zh-CN,zh;q=0.9");
        // getMethod.setHeader("Connection", "keep-alive");
        // getMethod.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");

        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");

        try {
            response = httpClient.execute(getMethod);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

        return response;
    }
}
