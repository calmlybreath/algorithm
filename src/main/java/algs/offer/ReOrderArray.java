package algs.offer;

import java.util.LinkedList;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {

    /**
     * 空间换时间的解法
     *
     * @param array the array
     */
    public void reOrderArray1(int[] array) {
        int[] newArray = new int[array.length];
        int j = 0;
        for (int anArray : array) {
            if ((anArray & 1) == 1) {
                newArray[j] = anArray;
                j++;
            }
        }
        for (int anArray : array) {
            if ((anArray & 1) == 0) {
                newArray[j] = anArray;
                j++;
            }
        }
        array = newArray;
    }

    /**
     * O(1)空间的解法
     *
     * @param array the array
     */
    public void reOrderArray2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                int j = i;
                int k = i;
                while (true) {
                    j--;
                    if (j < 0 || (array[j] & 1) == 1) {
                        break;
                    }
                    int temp = array[j];
                    array[j] = array[k];
                    array[k] = temp;
                    k = j;
                }
            }
        }
    }

    public void change(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            int a = n % 26;
            if (a == 0) {
                stringBuilder.append('z');
            } else {
                stringBuilder.append((char) (a + 64));
            }
            n = (n-1) / 26;
        }
        System.out.println(" " + stringBuilder.reverse().toString());
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        ReOrderArray reOrderArray = new ReOrderArray();
        for (int i = 1; i < 54; i++) {
            System.out.print("i = " + i);
            reOrderArray.change(i);
        }

        System.out.print("i = " + 10000);
        reOrderArray.change(10000);
    }
}
