package data.structure.test;

import data.structure.SimpleStack;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SimpleStackTest {
    private SimpleStack<Integer> stack;

    @Before
    public void init() {
        stack = new SimpleStack<>(0, 7);
        for (int i = 0; i < 2; i++) {
            stack.push(i);
        }
    }

    @Test
    public void testPush() {
        System.out.println("stack.toString() = " + stack.toString());
        System.out.println("stack.getCapacity() = " + stack.getCapacity());
    }

    @Test
    public void testPop() {
        assertEquals("", Integer.valueOf(1), stack.pop());
        assertEquals("", Integer.valueOf(0), stack.pop());
        //assertEquals("", Integer.valueOf(0), stack.pop());

    }
}
