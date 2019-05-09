package com.ewell.esb.common.config.handler;

public class DatabaseContextHolder {

    //用于保存线程共享变量
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
    public static void setDBKey(String dataSourceKey) {
        contextHolder.set(dataSourceKey);
    }
    public static String getDBKey() {
        return contextHolder.get();
    }
    public static void clearDBKey() {
        contextHolder.remove();
    }

}
