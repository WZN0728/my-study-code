package com;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author wuting
 * @date 2019/04/06
 */
public class OperationMap {

    public static void main(String[] args) {
        Map<Object, Object> treeMap = new TreeMap();
        treeMap.put(3, 1);
        treeMap.put(1, 1);
        treeMap.put(4, 1);
        treeMap.put(2, 1);
        for (Map.Entry<Object, Object> entrySet : treeMap.entrySet()) {
            System.out.printf("treeMap key -> %s%n", entrySet.getKey());
        }
        Map<Object,Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(3, 1);
        linkedHashMap.put(1, 1);
        linkedHashMap.put(4, 1);
        linkedHashMap.put(2, 1);
        for(Map.Entry<Object,Object> objectEntry : linkedHashMap.entrySet()){
            System.out.printf("linkedHashMap key -> %s%n", objectEntry.getKey());
        }
    }

}
