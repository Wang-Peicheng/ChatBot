package cn.chatbot.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 *
 */
public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/4844542545115218/topics?scope=unanswered_questions&count=20");

        // 需要cookie信息
        get.addHeader("cookie", "sajssdk_2015_cross_new_user=1; zsxq_access_token=8B398A10-28AC-3A9E-5D0C-485C7C7ED73F_7CFE20814F4EE31A; zsxqsessionid=e482e6f8b44404d343c80c231c295c11; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22185451545528842%22%2C%22first_id%22%3A%2218ec1139d6454a-0dbf50b2ac5a2e-4c657b58-1296000-18ec1139d65367%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThlYzExMzlkNjQ1NGEtMGRiZjUwYjJhYzVhMmUtNGM2NTdiNTgtMTI5NjAwMC0xOGVjMTEzOWQ2NTM2NyIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjE4NTQ1MTU0NTUyODg0MiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22185451545528842%22%7D%2C%22%24device_id%22%3A%2218ec1139d6454a-0dbf50b2ac5a2e-4c657b58-1296000-18ec1139d65367%22%7D");
        get.addHeader("Content-type","application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/1522421421281182/answer");
        post.addHeader("cookie", "sajssdk_2015_cross_new_user=1; zsxq_access_token=8B398A10-28AC-3A9E-5D0C-485C7C7ED73F_7CFE20814F4EE31A; zsxqsessionid=e482e6f8b44404d343c80c231c295c11; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22185451545528842%22%2C%22first_id%22%3A%2218ec1139d6454a-0dbf50b2ac5a2e-4c657b58-1296000-18ec1139d65367%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThlYzExMzlkNjQ1NGEtMGRiZjUwYjJhYzVhMmUtNGM2NTdiNTgtMTI5NjAwMC0xOGVjMTEzOWQ2NTM2NyIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjE4NTQ1MTU0NTUyODg0MiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22185451545528842%22%7D%2C%22%24device_id%22%3A%2218ec1139d6454a-0dbf50b2ac5a2e-4c657b58-1296000-18ec1139d65367%22%7D");
        post.addHeader("Content-type","application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"Test 03\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
