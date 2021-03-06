package com.wxj.codebaselearn.ms;


import java.util.*;

/**
 * @author wxj
 * @version 1.0
 * @description: 集合类不安全的问题
 * @date 2021/4/22 0022 20:05
 */
public class ContainerNotSafeDemo {
    /**
     * 笔记
     * 写时复制 copyOnWrite 容器即写时复制的容器 往容器添加元素的时候,不直接往当前容器object[]添加,而是先将当前容器object[]进行
     * copy 复制出一个新的object[] newElements 然后向新容器object[] newElements 里面添加元素 添加元素后,
     * 再将原容器的引用指向新的容器 setArray(newElements);
     * 这样的好处是可以对copyOnWrite容器进行并发的读,而不需要加锁 因为当前容器不会添加任何容器.所以copyOnWrite容器也是一种
     * 读写分离的思想,读和写不同的容器.
     *
     *
     * public boolean add(E e) {
     *  final ReentrantLock lock = this.lock;
     *  lock.lock();
     *  try {
     *      Object[] elements = getArray();
     *      int len = elements.length;
     *      Object[] newElements = Arrays.copyOf(elements, len + 1);
     *      newElements[len] = e;
     *      setArray(newElements);
     *      return true;
     *    } finally {
     *      lock.unlock();
     *    }
     * }
     *
     * @param args
     */
    public static void main(String[] args) {
//        List list = new CopyOnWriteArrayList();
        /*List list = new ArrayList();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(1, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }*/


        Map<Integer, Object> map = new HashMap<>();
        for (int i = 1; i <= 30; i++) {
            final int temp = i;
            new Thread(() -> {
                map.put(temp,UUID.randomUUID().toString().substring(1, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }

//        Collections.synchronizedList(list);

//        NavigableMap<String,Object> navigableMap = new NavigableMap<String, Object>() {
//        }
//
//        Collections.synchronizedS

/**
 * 1.故障现象 list  map set  NavigableMap sortedMap sortedSet 等等
 *  java.util.ConcurrentModificationException  当方法检测到对象的并发修改，但不允许这种修改时，抛出此异常
 * 2.导致原因
 *    并发争抢修改导致
 * 3.解决方案
 *  3.1 new Vector()
 *  3.2 Collections.synchronizedList(new ArrayList());
 *  3.3 new CopyOnWriteArrayList();
 *
 *
 * 4.优化建议
 */
    }
}