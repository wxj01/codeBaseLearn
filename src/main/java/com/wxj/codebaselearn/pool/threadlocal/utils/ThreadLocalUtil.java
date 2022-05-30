package com.wxj.codebaselearn.pool.threadlocal.utils;

/**
 * @author wxj
 * @version 1.0.0
 * @ClassName ThreadLocalUtil.java
 * @Description TODO ThreadLocal 工具类
 * @createTime 2022年05月30日 21:15:00
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ThreadLocalUtil {

    private static final ThreadLocal<Map<String, Object>> threadLocal = ThreadLocal.withInitial(() -> new HashMap<>(10));

    public static Map<String, Object> getThreadLocal() {
        return threadLocal.get();
    }

    public static <T> T get(String key) {
        Map<String, Object> map = threadLocal.get();
        return get(key, null);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String key, T defaultValue) {
        Map<String, Object> map = threadLocal.get();
        return (T) Optional.ofNullable(map.get(key)).orElse(defaultValue);
    }

    public static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        map.put(key, value);
    }

    public static void set(Map<String, Object> keyValueMap) {
        Map<String, Object> map = threadLocal.get();
        map.putAll(keyValueMap);
    }

    public static void remove() {
        threadLocal.remove();
    }

    @SuppressWarnings("unchecked")
    public static <T> T remove(String key) {
        Map<String, Object> map = threadLocal.get();
        return (T) map.remove(key);
    }

}
