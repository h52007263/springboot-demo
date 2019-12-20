package com.hzs.cache;

import cache.LRUCache;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author hezhensheng
 * @version 1.0
 * @description LRUCacheTest
 * @date 2019/12/20 22:36
 */

public class LRUCacheTest {
    @Test
    public void lruCacheTest() {
        LRUCache<Integer, Integer> map = new LRUCache<>(10);
        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }
        System.out.println(map.toString());
        map.get(6);
        System.out.println(map.toString());
        map.put(11, 11);
        System.out.println(map.toString());
    }

    @Test
    public void mathCeilTest() {
        System.out.println(Math.ceil(1.4));
    }
}
