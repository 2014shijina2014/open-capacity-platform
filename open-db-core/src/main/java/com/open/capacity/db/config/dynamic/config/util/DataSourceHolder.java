package com.open.capacity.db.config.dynamic.config.util;

/**
 * 用于数据源切换
 *
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2017年04月23日 下午20:01:06 类说明
 */
public class DataSourceHolder {
	private static final ThreadLocal<DataSourceKey> dataSourceKey = new ThreadLocal<>();

	public static DataSourceKey getDataSourceKey() {
		return dataSourceKey.get();
	}

	public static void setDataSourceKey(DataSourceKey type) {
		dataSourceKey.set(type);
	}

	public static void clearDataSourceKey() {
		dataSourceKey.remove();
	}

}