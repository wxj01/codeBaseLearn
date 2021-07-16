package com.wxj.codebaselearn.algorithm;

import sun.security.krb5.internal.crypto.dk.DkCrypto;

import java.awt.*;
import java.util.Hashtable;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 *  LRU 算法
 *
 *  1、save(key, value)，首先在 HashMap 找到 Key 对应的节点，如果节点存在，更新节点的值，并把这个节点移动队头。
 *      如果不存在，需要构造新的节点，并且尝试把节点塞到队头，如果LRU空间不足，则通过 tail 淘汰掉队尾的节点，同时在 HashMap 中移除 Key。
 *  2、get(key)，通过 HashMap 找到 LRU 链表节点，把节点插入到队头，返回缓存的值。
 *
 * @date 2021/7/16 0016 20:42
 */

class DLinkedNode{
    String key;
    int value;
    DLinkedNode pre;
    DLinkedNode post;
}

public class LRUCache {

    private Hashtable<String,DLinkedNode> cache = new Hashtable<>();
    private int count;
    private int capactiy;
    private DLinkedNode head,tail;


    public LRUCache(int capactiy){
        this.count = 0;
        this.capactiy = capactiy;

        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.pre = null;
        tail.post = null;

        head.post = tail;
        tail.pre = head;


    }


    public int get(String key){
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;// should raise exception here.
        }

        // move the accessed node to the head;
        this.moveToHead(node);
        return node.value;
    }


    public void set(String key,int value){
        DLinkedNode node = cache.get(key);

        if(node == null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key,newNode);
            this.addNode(newNode);

            ++count;

            if (count > capactiy){
                // pop the tail;
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }

        }else{
            // update the vaule;

            node.value = value;
            this.moveToHead(node);
        }
    }


    /**
     * Always add the new node right after head;
     */
    private void addNode(DLinkedNode node){
        node.pre = head;
        node.post = head.post;

//        tail.pre = node;
//        node.post = tail;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node){
        this.removeNode(node);
        this.addNode(node);
    }

    // pop the current tail.
    private  DLinkedNode popTail(){
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }
}