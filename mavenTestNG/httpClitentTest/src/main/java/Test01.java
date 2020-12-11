import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
    @Test
    public void test() throws Exception {

            // 创建带有默认配置的CloseableHttpClient实例。
            CloseableHttpClient httpclient = HttpClients.createDefault();
            try {
                // 创建一个HttpGet对象实例(如果是post请求则创建HttpPost对象实例)
                HttpGet httpGet = new HttpGet("http://httpbin.org/get");
                // 使用默认上下文执行HTTP请求。
                CloseableHttpResponse response1 = httpclient.execute(httpGet);
                // 底层的HTTP连接仍然由响应对象持有
                // 为了确保对系统资源的正确处理，用户必须调用CloseableHttpResponse#close()。
                // 注意，如果响应内容未被完全使用，则底层连接不能被安全重用，并将被连接管理器关闭和丢弃。
                try {
                    // 输出该响应的状态
                    System.out.println(response1.getStatusLine());
                    // 获得该响应的消息实体，如果有的话。实体是通过调用setEntity(HttpEntity entity)来提供的。
                    HttpEntity entity1 = response1.getEntity();
                    // 对响应主体做一些有用的事情并确保它被完全消耗掉
                    // EntityUtils工具类提供了很多静态的方法用来处理HttpEntity对象实例
                    EntityUtils.consume(entity1);
                    //释放资源
                } finally {
                    response1.close();
                }
                // 创建一个HttpPost对象实例，对应Post请求
                HttpPost httpPost = new HttpPost("http://httpbin.org/post");
                //创建ArrayList列表
                //NameValuePair接口定义了用作 HTTP 消息元素的名称/值对参数。
                List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                //BasicNameValuePair类为NameValuePair接口的基本实现类
                //这里调用了BasicNameValuePair类的构造方法
                nvps.add(new BasicNameValuePair("username", "vip"));
                nvps.add(new BasicNameValuePair("password", "secret"));
                //调用setEntity方法将实体与此请求关联。
                //UrlEncodedFormEntity(nvps)：通过参数列表创建具有默认编码方式的UrlEncodedFormEntity对象实例
                httpPost.setEntity(new UrlEncodedFormEntity(nvps));
                //执行http请求
                CloseableHttpResponse response2 = httpclient.execute(httpPost);

                try {
                    System.out.println(response2.getStatusLine());
                    HttpEntity entity2 = response2.getEntity();
                    // 对响应主体做一些有用的事情并确保它被完全消耗掉
                    EntityUtils.consume(entity2);
                    //释放资源
                } finally {
                    response2.close();
                }
            } finally {
                httpclient.close();
            }
        }
}
