package com.hackceiba.cache;

import com.hackaceiba.cache.CacheWrapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CacheWrapperTest {

    private CacheWrapper cacheWrapper;

    @Before
    public void init(){
        this.cacheWrapper = new CacheWrapper();
    }

    @Test
    public void verifyNullObjectWhenDoesntExist() {

        Object obj = this.cacheWrapper.get("2");
        Assert.assertNull(obj);
    }

    @Test
    public void verifyObjectWhenExist() {
        String name = "Name";
        this.cacheWrapper.put("1", name, 10000);

        String nameRetrieved = (String) this.cacheWrapper.get("1");
        assertEquals(name, nameRetrieved);
    }

}
