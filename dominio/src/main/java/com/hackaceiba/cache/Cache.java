package com.hackaceiba.cache;

public interface Cache {

    void put(String key, Object object, int millis);

    Object get(String key);

}
