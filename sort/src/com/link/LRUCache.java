package com.link;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wuting
 * @date 2020/10/18
 */
public class LRUCache {

    private class CacheNode {
        private int key;
        private int value;
        private CacheNode next;
        private CacheNode pre;

        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.pre = null;
        }
    }

    private int capacity;
    private Map<Integer, CacheNode> map = new HashMap<>();
    //声明一个无效的头节点,只是用来记为一个头
    private CacheNode head = new CacheNode(-1, -1);
    //声明一个无效的尾节点,只是用来记为一个尾
    private CacheNode tail = new CacheNode(-1, -1);

    //上面这两种声明方式只是单纯的为了记录本身,
    // 因为如果你要移除链表中的节点的时候有这样的小技巧会很轻松,
    // 否则你要记住链表的两边,那样将会变得非常的混乱
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = tail;
        this.tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        CacheNode current = map.get(key);
        current.pre.next = current.next;
        current.next.pre = current.pre;
        moveToTail(current);
        return current.value;
    }

    //这一步属于将最新的元素移动向最尾端, 发生在get调用后以及put后
    private void moveToTail(CacheNode current) {
        current.pre = tail.pre;
        tail.pre = current;
        current.pre.next = current;
        current.next = tail;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            return;
        }
        //当lru缓存已经达到它得上线得时候,就要移除当前head的下一个元素,
        // 因为当前链表前后都是由哨兵节点的无效元素,所以只需要移除当前head的下一个元素
        if (map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
        //这里边就是真正的要去添加新增的数据到map中
        CacheNode cacheNode = new CacheNode(key, value);
        map.put(key, cacheNode);
        //将新增的数据放到尾节点,因为lru算法就是将最近最多使用的值放在链表的尾部
        moveToTail(cacheNode);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        System.out.println(lruCache.toString());
    }

}
