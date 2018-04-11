
package com.open.capacity;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class TestClient {
	//采用单节点刷新技术，没有批量刷新，如果需要批量刷新需结合kafka集群技术
	//参考open-config-bus，open-config-client
	public static void main(String[] args) throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://localhost:5555/refresh");
		HttpResponse response = client.execute(post);
		System.out.println(EntityUtils.toString(response.getEntity()));
	}

}
