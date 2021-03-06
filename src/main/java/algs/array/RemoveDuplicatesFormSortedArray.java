package algs.array;


/**
 * The type Remove duplicates form sorted array.
 * leetcode 26
 *
 * @author lrq
 * @date 2018/04/20
 */
public class RemoveDuplicatesFormSortedArray {
    /**
     * Remove duplicates int.
     *
     * @param nums the nums
     * @return the int
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preIndex = 0;
        boolean swap = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[preIndex]) {
                preIndex++;
                if (swap) {
                    nums[preIndex] = nums[i];
                }
            } else {
                swap = true;
            }
        }
        return preIndex + 1;
    }
}
