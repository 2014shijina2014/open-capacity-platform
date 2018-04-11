package com.open.capacity.db.config.dynamic.config.util;

/**
 * 用于数据源切换
 *
 * @author owen
 * @create 2017年7月2日
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