package com.open.capacity.es.config;

import java.net.InetAddress;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * Title: esConfig
 * 
 * @author yuanpb
 * 
 * @date 2018年5月30日
 * 
 */
@Configuration
public class esConfig {

	/**
	 * elk集群地址
	 */
	@Value("${elasticsearch.ip}")
	private String hostName;
	/**
	 * 端口
	 */
	@Value("${elasticsearch.port}")
	private String port;
	/**
	 * 集群名称
	 */
	@Value("${elasticsearch.cluster.name}")
	private String clusterName;

	/**
	 * 连接池
	 */
	@Value("${elasticsearch.pool}")
	private String poolSize;

	@Bean
	public TransportClient init() {

		TransportClient transportClient = null;

		System.out.println("...........init...........");

		try {
			// 配置信息
			Settings esSetting = Settings.builder().put("cluster.name", clusterName)
					.put("client.transport.ignore_cluster_name", true) // 如果集群名不对，也能连接
					// .put("client.transport.sniff", true)// 增加嗅探机制，找到ES集群
					//.put("thread_pool.search.size", Integer.parseInt(poolSize))// 增加线程池个数，暂时设为5
					.build();
			transportClient = new PreBuiltTransportClient(esSetting);
			System.out.println("...........new PreBuiltTransportClient  success...........");
			TransportAddress inetSocketTransportAddress = new TransportAddress(
					InetAddress.getByName(hostName), Integer.valueOf(port));
			transportClient.addTransportAddress(inetSocketTransportAddress);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return transportClient;
	}
}
