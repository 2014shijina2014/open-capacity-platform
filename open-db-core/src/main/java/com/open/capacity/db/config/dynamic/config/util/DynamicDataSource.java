package com.open.capacity.db.config.dynamic.config.util;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2017年04月23日 下午20:01:06 类说明 类说明
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	private Map<Object, Object> datasources;

	public DynamicDataSource() {
		datasources = new HashMap<>();

		super.setTargetDataSources(datasources);

	}

	public <T extends DataSource> void addDataSource(DataSourceKey key, T data) {
		datasources.put(key, data);
	}

	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceHolder.getDataSourceKey();
	}

}
