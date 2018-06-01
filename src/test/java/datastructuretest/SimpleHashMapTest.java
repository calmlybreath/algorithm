package datastructuretest;

import datastructure.SimpleHashMap;
import org.junit.Assert;
import org.junit.Test;

public class SimpleHashMapTest {
    @Test
    public void testGet() {
        SimpleHashMap<String, String> hashMap = new SimpleHashMap<>();
        hashMap.put("h1", "test1");
        hashMap.put("h2", "test2");
        Assert.assertEquals(hashMap.get("h1"),"test1");
        Assert.assertEquals(hashMap.get("h2"),"test2");
        hashMap.put("h1", "test3");
        Assert.assertEquals(hashMap.get("h1"),"test3");
    }
}
