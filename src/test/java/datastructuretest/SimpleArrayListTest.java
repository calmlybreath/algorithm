package datastructuretest;

import datastructure.SimpleArrayList;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class SimpleArrayListTest {
    private SimpleArrayList<Integer> simpleArrayList;

    @Before
    public void before() {
        simpleArrayList = new SimpleArrayList<>();
        for (int i = 0; i < 20; i++) {
            simpleArrayList.add(i);
        }
    }

    @After
    public void after() {
        System.out.println("111 = " + 111);
    }

    @Test
    public void testAdd() {
        simpleArrayList.add(30);
        System.out.println("simpleArrayList.toString() = " + simpleArrayList.toString());
    }

    @Test
    public void testInitLength() {
        SimpleArrayList<?> simpleArrayList = new SimpleArrayList<>();
        SimpleArrayList<?> simpleArrayList1 = new SimpleArrayList<>(0);
        SimpleArrayList<?> simpleArrayList2 = new SimpleArrayList<>(1);
        SimpleArrayList<?> simpleArrayList3 = new SimpleArrayList<>(13);
        assertEquals("", 10, simpleArrayList.getCapacity());
        assertEquals("", 0, simpleArrayList1.getCapacity());
        assertEquals("", 1, simpleArrayList2.getCapacity());
        assertEquals("", 13, simpleArrayList3.getCapacity());
    }

    @Test
    public void testRemoveBatch() {
        simpleArrayList.removeBatch(1, 16);
        System.out.println("simpleArrayList.toString() = " + simpleArrayList.toString());
    }

}
