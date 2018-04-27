package com.open.capacity.controller;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2017年11月28日 下午21:52:43
 */
@Controller
@RequestMapping("/eureka/")
public class EurekaController {
	
   
	private static final Logger LOGGER = LoggerFactory.getLogger(EurekaController.class);

	@Autowired
	private DiscoveryClient discoveryClient;

	@ResponseBody
	@RequestMapping(value = "status", method = RequestMethod.GET)
	public String status() {
		String url = "http://127.0.0.1:1111/eureka/status";
		return getinfo(url);
	}

	@ResponseBody
	@RequestMapping(value = "apps", method = RequestMethod.GET)
	public String apps() {
		String url = "http://127.0.0.1:1111/eureka/apps";
		return getinfo(url);
	}
	
	 
	

	@ResponseBody
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public Map list() {

		List<String> list = discoveryClient.getServices();
		Map res = new HashMap<>();
		for (Iterator<String> it = list.iterator(); it.hasNext();) {
			String serviceName = it.next();

			List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);

			for (Iterator<ServiceInstance> its = instances.iterator(); its.hasNext();) {
				ServiceInstance instance = its.next();

				res.putAll(instance.getMetadata());

			}

		}

		return res;
	}

	@ResponseBody
	@RequestMapping(value = "appsmd", method = RequestMethod.POST)
	public String appsmd(@RequestParam(value = "name", required = false) String str) {
		String url = "http://127.0.0.1:1111/eureka/apps/" + str;
		return getinfo(url);
	}

	@ResponseBody
	@RequestMapping(value = { "appsmddel" }, method = RequestMethod.POST)
	public String appsmddel(@RequestParam(value = "name", required = false) String str) {
		String url = "http://127.0.0.1:1111/metadata/apps/" + str;
		return getinfo_del(url);
	}

	@ResponseBody
	@RequestMapping(value = "operate", method = RequestMethod.POST)
	public String operate(@RequestBody HashMap<String, String> inmap) {
		LOGGER.info(inmap.toString());
		String op = "";
		int post2get = 0;
		if (inmap.get("operate").equals("1")) {// 暂停
			op = "pause";
		}
		if (inmap.get("operate").equals("2")) {// 挂起
			op = "pause";
		}
		if (inmap.get("operate").equals("3")) {// 恢复
			op = "resume";
		}
		if (inmap.get("operate").equals("4")) {// 刷新
			op = "refresh";
		}
		if (inmap.get("operate").equals("5")) {// 主机性能指标
			op = "metrics";
			post2get = 1;
		}

		String url = "http://" + inmap.get("ip") + ":" + inmap.get("port") + "/" + op;

		return getoperate(url, post2get, "", "");
	}

	private static String getoperate(String url, int post2get, String... str) {

		String bodyAsString = "";
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		try {
			RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(10 * 1000)
					.setConnectTimeout(10 * 1000).setSocketTimeout(10 * 1000).build();
			if (post2get == 1) {
				HttpGet po = new HttpGet(url);

				po.setConfig(requestConfig);
				CloseableHttpResponse response = httpClient.execute(po);
				bodyAsString = EntityUtils.toString(response.getEntity());
				LOGGER.info(bodyAsString.toString());
				return bodyAsString.toString();
			}
			if (post2get == 3) {

				HttpPost po = new HttpPost(url);
				po.addHeader(new BasicHeader("Cookie", "JSESSIONID=" + str[0]));
				po.setConfig(requestConfig);
				String queryCase = "name=admin&password=admin&remember=0";
				StringEntity reqEntity = new StringEntity(queryCase);
				reqEntity.setContentType("application/x-www-form-urlencoded");
				po.setEntity(reqEntity);
				CloseableHttpResponse response = httpClient.execute(po);
				bodyAsString = EntityUtils.toString(response.getEntity());
				LOGGER.info(bodyAsString.toString());
				return bodyAsString;

			}
			if (post2get == 4) {
				HttpGet po = new HttpGet(url);
				po.addHeader(new BasicHeader("Cookie", "JSESSIONID=" + str[0] + ";DISCONF=" + str[1]));
				po.setConfig(requestConfig);
				CloseableHttpResponse response = httpClient.execute(po);
				bodyAsString = EntityUtils.toString(response.getEntity());
				LOGGER.info(bodyAsString.toString());
				return bodyAsString;
			}
			if (post2get == 5) {

				HttpPut po = new HttpPut(url);
				po.addHeader(new BasicHeader("Cookie", "JSESSIONID=" + str[0] + ";DISCONF=" + str[1]));
				po.setConfig(requestConfig);
				String text = "fileContent=" + str[2];
				StringEntity reqEntity = new StringEntity(text);
				reqEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
				po.setEntity(reqEntity);
				CloseableHttpResponse response = httpClient.execute(po);
				bodyAsString = EntityUtils.toString(response.getEntity());
				LOGGER.info(bodyAsString.toString());
				return bodyAsString;
			}
			if (post2get == 6) {

				HttpPost po = new HttpPost(url);
				po.setConfig(requestConfig);
				StringEntity reqEntity = new StringEntity(str[0]);
				reqEntity.setContentType("application/json;charset=utf-8");
				po.setEntity(reqEntity);
				CloseableHttpResponse response = httpClient.execute(po);
				bodyAsString = EntityUtils.toString(response.getEntity());
				LOGGER.info(bodyAsString.toString());
				return bodyAsString;

			} else {
				HttpPost po = new HttpPost(url);
				if (str != null && str.length > 0) {
					po.addHeader(new BasicHeader("Cookie", "JSESSIONID=" + str[0]));
				}
				StringEntity reqEntity = new StringEntity("");
				reqEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
				po.setEntity(reqEntity);

				po.setConfig(requestConfig);
				CloseableHttpResponse response = httpClient.execute(po);
				bodyAsString = EntityUtils.toString(response.getEntity());
				LOGGER.info(bodyAsString.toString());
				return bodyAsString;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{}";
	}

	private static String getinfo(String url) {

		String bodyAsString = "";
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		try {
			RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(50 * 1000)
					.setConnectTimeout(50 * 1000).setSocketTimeout(50 * 1000).build();
			HttpGet po = new HttpGet(url);
			if (url.indexOf("apps") > 0) {
				po.setHeader("Accept", "application/json");
			}
			po.setConfig(requestConfig);
			CloseableHttpResponse response = httpClient.execute(po);
			bodyAsString = EntityUtils.toString(response.getEntity());
			if (url.indexOf("apps") > 0) {
				LOGGER.info(bodyAsString.toString());
				return bodyAsString;
			}
			ObjectMapper objectMapper = new ObjectMapper();
			XmlMapper xmlMapper = new XmlMapper();
			StringWriter w = new StringWriter();
			JsonParser jp;
			try {
				jp = xmlMapper.getFactory().createParser(bodyAsString);
				JsonGenerator jg = objectMapper.getFactory().createGenerator(w);
				while (jp.nextToken() != null) {
					jg.copyCurrentEvent(jp);
				}
				jp.close();
				jg.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			LOGGER.info(w.toString());
			return w.toString();
			// logger.info("RestContr "+bodyAsString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{}";
	}

	private static String getinfo_put(String url) {

		String bodyAsString = "";
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		try {
			RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(50 * 1000)
					.setConnectTimeout(50 * 1000).setSocketTimeout(50 * 1000).build();
			HttpPut po = new HttpPut(url);

			po.setConfig(requestConfig);
			CloseableHttpResponse response = httpClient.execute(po);
			bodyAsString = EntityUtils.toString(response.getEntity());

			// LOGGER.info(w.toString());
			return "{}";
			// logger.info("RestContr "+bodyAsString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{}";
	}

	private static String getinfo_del(String url) {
		String bodyAsString = "";
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		try {
			RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(50000)
					.setConnectTimeout(50000).setSocketTimeout(50000).build();
			HttpDelete po = new HttpDelete(url);

			po.setConfig(requestConfig);
			CloseableHttpResponse response = httpClient.execute(po);
			bodyAsString = EntityUtils.toString(response.getEntity());

			return "{}";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{}";
	}
}
