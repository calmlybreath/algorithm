package datastructuretest;

import datastructure.SimpleBinaryTree;
import org.junit.Before;
import org.junit.Test;

public class SimpleBinaryTreeTest {
    private SimpleBinaryTree<Integer> tree;

    @Before
    public void init() {
        tree = new SimpleBinaryTree<Integer>();
    }

    @Test
    public void testConstruct() {

    }

    @Test
    public void testAdd() {
        tree.add(10);
        tree.add(7);
        tree.add(13);
        tree.add(8);
        tree.add(6);
        tree.add(18);
        tree.add(56);
        tree.add(1);
        tree.order();
    }

    @Test
    public void testOrder(){
        tree.add(10);
        tree.add(7);
        tree.add(13);
        tree.order();
    }
}
