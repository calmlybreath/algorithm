package datastructuretest;

import datastructure.SimpleBinaryTree;
import org.junit.Before;
import org.junit.Test;


public class SimpleBinaryTreeTest {
    private SimpleBinaryTree<Integer> tree;

    @Before
    public void init() {
        tree = new SimpleBinaryTree<Integer>();
        tree.add(10);
        tree.add(7);
        tree.add(13);
        tree.add(8);
        tree.add(6);
        tree.add(18);
        tree.add(56);
        tree.add(1);
    }

    @Test
    public void testConstruct() {

    }

    @Test
    public void testAdd() {
        //tree.order();
        tree.dfs();
    }

    @Test
    public void testRemove(){
        tree.dfs();
        System.out.println("---------------------");
        tree.remove(7);
        tree.dfs();
        System.out.println("---------------------");
        tree.remove(1);
        tree.dfs();
        System.out.println("---------------------");
        tree.remove(10);
        tree.dfs();
        System.out.println("---------------------");
    }

    @Test
    public void testOrder(){
        tree.add(10);
        tree.add(7);
        tree.add(13);
    }

    @Test
    public void testFind(){
        SimpleBinaryTree.NodeInfo<Integer> integerNodeInfo = tree.find(20);
        if(integerNodeInfo==null){
            System.out.println(" = " );
        }else {
            System.out.println("integerNode = " + integerNodeInfo.getCurrentNode().getValue());
        }
    }
}
