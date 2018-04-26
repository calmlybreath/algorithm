package algs.leetcode.array.test;

import algs.leetcode.array.RemovDuplicatesFormSortedArray;
import org.junit.Assert;
import org.junit.Test;

public class RemovRepeatItemFormSortArrayTest {
    @Test
    public void testImpl(){
        Assert.assertEquals(5, RemovDuplicatesFormSortedArray.removeDuplicates(new int[]{1,1,1,2,2,3,3,4,5}));
        Assert.assertEquals(1, RemovDuplicatesFormSortedArray.removeDuplicates(new int[]{0,0,0,0,0}));
        Assert.assertEquals(5, RemovDuplicatesFormSortedArray.removeDuplicates(new int[]{0,1,2,3,4,4,4,4,4,4}));

    }
}
