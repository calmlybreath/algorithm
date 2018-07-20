package algs.offer;

/*
 * 题目描述:
 *  在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 *  每一列都按照从上到下递增的顺序排序。请完成一个函数，
 *  输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * */
public class Find2darray {
    public boolean find(int target, int[][] array) {
        int x = array.length - 1;
        int y = array[0].length - 1;
        int i, j;
        for (int k = 0; k <= x && target >= array[k][0]; k++) {
            i = 0;
            j = y;
            while (i <= j) {
                int mid = (i + j) / 2;
                if (target < array[k][mid]) {
                    j = mid - 1;
                } else if (target > array[k][mid]) {
                    i = mid + 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
