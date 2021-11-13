package com.hackaceiba.cache;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
public class CacheWrapper implements Cache {

    Map<String, CacheEntry> map;

    public CacheWrapper() {
        this.map = new HashMap<>();
    }

    @Override
    public void put(String key, Object object, int millis){
        map.put(key, getCacheEntry(object, millis));
    }

    @Override
    public Object get(String key) {

        if (key.trim().isEmpty())
            return null;

        CacheEntry cacheEntry = map.get(key);

        if(cacheEntry == null)
            return null;

        if ( cacheEntry.getExpireDate() < getSystemTime()) {
            map.remove(key);
            return null;
        }

        return cacheEntry.getObject();
    }

    protected long getSystemTime() {
        return new Date().getTime();
    }

    protected CacheEntry getCacheEntry(Object object, int millis) {
        return new CacheEntry(object, millis);
    }


}
