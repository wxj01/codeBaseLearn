package com.wxj.codebaselearn.ms;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * 验证 LinkedBlockingDeque是不是无界的，从逻辑上说链表 这种数据结构是无界的
 * 这里LinkedBlockingDeque 不指定大小的时候默认是 Integer.MAX_VALUE ，如果内存足够大，
 *  即使byte 类型的 放入 LinkedBlockingDeque ，差不多4T 大小，很多情况直接就OOM ,至少没有见过分配给jvm 4T 的内存
 * @date 2021/4/26 0026 16:07
 */
public class LinkedBlockingDequeDemo {
    public static void main(String[] args) {

        LinkedBlockingDeque<Object> linkedBlockingDeque = new LinkedBlockingDeque<>(10);

        for (int i = 0; i < 30; i++){
            System.out.println("第几个"+i);
            linkedBlockingDeque.add("a"+i);

            System.out.println("linkedBlockingDeque 的长度"+linkedBlockingDeque.size());
        }

    }
}