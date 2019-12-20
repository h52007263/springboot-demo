package cache;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author hezhensheng
 * @version 1.0
 * @description LRUCache
 * @date 2019/12/20 22:30
 */

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    /**
     * 缓存容量
     */
    private final int CACHE_SIZE;

    /**
     * 初始化CACHE_SIZE的map大小
     * @param cacheSize
     */
    public LRUCache(int cacheSize) {
        super((int)(Math.ceil(cacheSize / 0.75) + 1), 0.75f, true);
        CACHE_SIZE = cacheSize;
    }

    /**
     * 超出缓存容量则删除
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > CACHE_SIZE;
    }
}
