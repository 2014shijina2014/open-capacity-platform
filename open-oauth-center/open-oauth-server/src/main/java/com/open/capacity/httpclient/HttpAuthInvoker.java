package com.open.capacity.httpclient;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;
/** 
* @author 作者 owen E-mail: wang.wen@neusoft.com
* @version 创建时间：2017年12月14日 上午11:13:53 
* 类说明 http访问拿认证服务器的token
*/
public class HttpAuthInvoker {

	private static final String TOKEN_URL = "http://127.0.0.1:8001/auth/oauth/token";
	public static String access_token;

	private HttpClientBuilder httpClientBuilder;
	private CloseableHttpClient httpClient;

	// private static final Object MAPPER = new ObjectMapper();
	public void start() throws Exception {

		httpClientBuilder = HttpClientBuilder.create();
		// CloseableHttpClient httpClient = HttpClients.createDefault();
		// http POST
		// HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		HttpPost httpPost = new HttpPost(TOKEN_URL);
		// HttpGet httpGet = new HttpGet(url);
		// httpPost.addHeader("Authorization", "Basic cGljYzpzZWNyZXQ=");//
		CredentialsProvider provider = new BasicCredentialsProvider();

		AuthScope scope = new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT, AuthScope.ANY_REALM);
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("webApp", "webApp");
		provider.setCredentials(scope, credentials);

		List<NameValuePair> formParams = new ArrayList<NameValuePair>();
		formParams.add(new BasicNameValuePair("grant_type", "password"));
		formParams.add(new BasicNameValuePair("scope", "app"));
		formParams.add(new BasicNameValuePair("username", "admin"));
		formParams.add(new BasicNameValuePair("password", "123456"));
		HttpEntity entity = new UrlEncodedFormEntity(formParams, "UTF-8");
		httpPost.setEntity(entity);
		httpClientBuilder.setDefaultCredentialsProvider(provider);
		httpClient = httpClientBuilder.build();
		CloseableHttpResponse response = null;
		try {

			response = httpClient.execute(httpPost);

			String content = EntityUtils.toString(response.getEntity(), "UTF-8");

			JSONObject jsonObject = JSONObject.fromObject(content);
			access_token = jsonObject.getString("access_token");
			System.out.println("得到:access_token : " + access_token);
		} finally {
			if (response != null) {
				response.close();
			}

			httpClient.close();

		}

	}

	 
	
	public static void main(String[] args) throws Exception {
		new HttpAuthInvoker().start();

	}
	
}