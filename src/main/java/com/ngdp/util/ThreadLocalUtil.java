package com.ngdp.util;

import java.util.HashMap;
import java.util.Map;

import com.ngdp.bean.JwtData;
import com.ngdp.exception.SystemException;

public class ThreadLocalUtil {
    private static final ThreadLocal<Map<String, Object>> dataMapThreadLocal = new ThreadLocal<Map<String, Object>>();

    private static final String REQUEST_METHOD = "requestMethod";    //本次请求的method
    private static final String REQUEST_ID = "requestId";
    private static final String JWT_DATA = "jwtData";
    private static final String IP = "ip";
    private static final String MAC = "mac";
    public static final String EXTEND_FIELDS = "extendFields";
    public static final String DATA_PRIVILEGE_SHOW = "dataPrivilegeShow";

    /**
     * 设置用户信息
     *
     * @param jwtData
     */
    public static void setJwtData(JwtData jwtData) {
        set("jwtData", jwtData);
    }

    /**
     * 返回用户信息
     *
     * @return
     */
    public static JwtData getJwtData() {
        return get(JWT_DATA);
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    public static String getUserId() {
        JwtData jwtData = get(JWT_DATA);
        if (null == jwtData) {
            throw new SystemException("查询用户信息失败");
        }

        return jwtData.getUserId();
    }

    /**
     * 获取本次请求ip地址
     *
     * @return
     */
    public static String getIp() {
        return get(IP);
    }

    /**
     * 设置本次请求ip地址
     *
     * @param ip
     */
    public static void setIp(String ip) {
        set(IP, ip);
    }

    /**
     * 获取本次请求mac地址
     *
     * @return
     */
    public static String getMac() {
        return get(MAC);
    }

    /**
     * 设置本次请求mac地址
     *
     * @param mac
     */
    public static void setMac(String mac) {
        set(MAC, mac);
    }

    public static void setRequestMethod(String requestMethod) {
        set(REQUEST_METHOD, requestMethod);
    }

    public static String getRequestMethod() {
        return get(REQUEST_METHOD);
    }

    public static void setRequestId(String requestId) {
        set(REQUEST_ID, requestId);
    }

    public static String getRequestId() {
        return get(REQUEST_ID);
    }

    /**
     * 从当前线程变量副本中返回当前保存的map对象,如果不存在，则进行初始化
     *
     * @return
     */
    private static Map<String, Object> getDataMap() {
        Map<String, Object> dataMap = dataMapThreadLocal.get();
        if (dataMap == null) {
            dataMap = new HashMap<String, Object>();
            dataMapThreadLocal.set(dataMap);
        }
        return dataMap;
    }

    /**
     * 清除数据
     */
    public static void clear() {
        getDataMap().clear();
    }

    /**
     * 设置值
     *
     * @param key
     * @param value
     */
    public static void set(String key, Object value) {
        getDataMap().put(key, value);
    }

    /**
     * 获取值
     *
     * @param key
     * @param <T>
     * @return
     */
    public static <T> T get(String key) {
        return (T) getDataMap().get(key);
    }
}
