package com.hackaceiba.cache;

import java.util.Date;

public class CacheEntry {

    private Object object;
    private long createTimeMillis;
    private int TTLMillis;
    private long expiredTimeMillis;

    public CacheEntry(Object object, int TTLMillis) {
        this.object = object;
        this.createTimeMillis = getSystemTime();
        this.TTLMillis = TTLMillis;
        this.expiredTimeMillis = this.createTimeMillis + this.TTLMillis;
    }

    protected long getSystemTime() {
        return new Date().getTime();
    }

    public long getExpireDate() {
        return expiredTimeMillis;
    }

    public Object getObject() {
        return object;
    }



}
