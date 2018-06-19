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
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
/** 
* @author 作者 owen E-mail: wang.wen@neusoft.com
* @version 创建时间：2017年12月14日 上午11:13:53 
* 类说明 http访问拿认证服务器的token
*/
public class HttpAuthInvoker {
	
	private static final String BASE_URL="http://127.0.0.1:8010/hello";
	private static final String TOKEN_URL = "http://127.0.0.1:8000/auth/oauth/token";
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
			
			JSONObject  jsonObject = JSONObject.parseObject(content);
			access_token = jsonObject.getString("access_token");
			System.out.println("得到:access_token : " + access_token);
		} finally {
			if (response != null) {
				response.close();
			}

			httpClient.close();

		}
		
//		String content = doAnotherGet(access_token);
//		System.out.println(content);

	}

	private String doAnotherGet(String json) throws Exception {
		// 创建代理地址实例
		// HttpHost proxy = new HttpHost("10.1.249.58", 3128);
		// 创建路由 使用DefaultProxyRoutePlanner
		// DefaultProxyRoutePlanner routePlanner = new
		// DefaultProxyRoutePlanner(proxy);
		// 路由添加到httpclient 实例创建中
		// CloseableHttpClient httpClient
		// =HttpClients.custom().setRoutePlanner(routePlanner).build();
		//
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建http POST请求
		HttpGet httpGet = new HttpGet(BASE_URL);
		// HttpGet httpGet = new HttpGet(url);
		// URL url = new URL(BASE_URL);

		httpGet.addHeader("Authorization", "Bearer " + json);

		CloseableHttpResponse response = null;
		try {
			// 执行请求
			response = httpClient.execute(httpGet);
			// 判断返回状态是否为200

			String content = EntityUtils.toString(response.getEntity(), "UTF-8");

			return content;
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