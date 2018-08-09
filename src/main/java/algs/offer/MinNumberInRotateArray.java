package algs.offer;

/**
 * The type Min number in rotate array.
 */
public class MinNumberInRotateArray {

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，
     * 我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，
     * 输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，
     * 该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
     *
     * @param array the array
     * @return the int
     */
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        //find the min item index (需考虑有相同数字的情况)
        //利用二分查找，如果元素大于array[0],则最小元素在右边
        //如果元素小于array[array.length-1],则最小元素在左边
        int max = array.length;
        int min = 0;
        int mid;
        while (min <= max) {
            mid = (min + max) >> 1;
            if (array[mid] >= array[0]) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return array[min];
    }

    public static void main(String[] args) {
        int[] arr=new int[]{3,4,5,1,2};
        int i = new MinNumberInRotateArray().minNumberInRotateArray(arr);
        System.out.println("i = " + i);
    }
}
