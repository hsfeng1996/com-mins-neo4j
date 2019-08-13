package com.mins.neo4j.util;

import java.util.HashMap;
import java.util.Map;

/*
 *  @Author hsfeng
 *  @Create 2019/7/27 16:24
 * */
public class MapHash {

    public static <K extends Integer, V> Map<Integer, V> hashMap(Iterable<V> iterable){
        Map<Integer, V> hashMap = new HashMap<>();
        for(V v: iterable){
            Integer hash = v.hashCode();
            hashMap.put(hash, v);
        }
        return hashMap;
    }
}
