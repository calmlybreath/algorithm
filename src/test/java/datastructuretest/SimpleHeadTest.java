package datastructuretest;

import datastructure.SimpleHeap;
import org.junit.Before;
import org.junit.Test;

public class SimpleHeadTest {
    private SimpleHeap<Integer> heap;
    @Before
    public void testInstance(){
        heap=new SimpleHeap<>(2);
        heap.add(10);
        heap.add(13);
        heap.add(9);
        heap.add(7);
        heap.add(8);
        heap.add(17);
        heap.add(1);
    }
    @Test
    public void testAdd(){
        heap.add(10);
        heap.add(13);
        heap.add(9);
        heap.add(7);
        heap.add(8);
        heap.add(17);
        heap.add(1);
    }

    @Test
    public void testGet(){
        System.out.println("heap.getSize() = " + heap.getSize());
        int size=heap.getSize();
        for (int i = 0; i <size ; i++) {
            System.out.println("i = " + heap.get());
        }

    }
}
