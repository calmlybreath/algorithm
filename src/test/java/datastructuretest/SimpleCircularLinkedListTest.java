package datastructuretest;

import datastructure.SimpleCircularLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleCircularLinkedListTest {
    @Before
    public void init() {

    }

    @Test
    public void testConstruct() {
        SimpleCircularLinkedList<Integer> list1 = new SimpleCircularLinkedList<>();
        Assert.assertTrue(list1.isEmpty());
        SimpleCircularLinkedList<Integer> list2 = new SimpleCircularLinkedList<>(1);
        Assert.assertFalse(list2.isEmpty());
        Assert.assertEquals(Integer.valueOf(1),list2.poll());
        Assert.assertTrue(list1.isEmpty());
    }

    @Test
    public void testAdd() {
        SimpleCircularLinkedList<Integer> list = new SimpleCircularLinkedList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        Assert.assertEquals("0 1 2 ",list.toString());
    }

    @Test
    public void testPoll(){
        SimpleCircularLinkedList<Integer> list = new SimpleCircularLinkedList<>();
        for (int i = 0; i <3 ; i++) {
            list.add(i);
        }
        Assert.assertEquals(Integer.valueOf(0),list.poll());
        Assert.assertEquals(Integer.valueOf(1),list.poll());
        Assert.assertEquals(Integer.valueOf(2),list.poll());
        Assert.assertTrue(list.isEmpty());

    }

}
