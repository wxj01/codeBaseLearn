package com.wxj.codebaselearn.ms;

import java.util.WeakHashMap;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/4/23 0023 15:22
 */
public class MyWeakHashMap {
    public static void main(String[] args) {
        WeakHashMap<Integer, String> weakHashMap = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value = "WeakHashMap";

        weakHashMap.put(key,value);
        System.out.println(weakHashMap);

        key = null;
        System.out.println(weakHashMap);

        System.gc();
        System.out.println(weakHashMap + "\t" + weakHashMap.size());

    }
}