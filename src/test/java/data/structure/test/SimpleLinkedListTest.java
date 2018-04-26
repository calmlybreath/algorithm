package data.structure.test;

import data.structure.SimpleLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleLinkedListTest {
    private SimpleLinkedList<Integer> list = new SimpleLinkedList<>();

    @Before
    public void init() {
        for (int i = 0; i < 2; i++) {
            list.add(i);
        }
    }

    @Test
    public void testAdd() {
        System.out.println("list.toString() = " + list.toString());
    }

    @Test
    public void TestReverse(){
        //list.unlinkLast();
        list.reverse();
        System.out.println("list.toString() = " + list.toString());
    }
}
