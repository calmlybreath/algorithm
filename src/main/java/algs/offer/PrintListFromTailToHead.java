package algs.offer;

import java.util.ArrayList;

/*
 *  题目描述
 *  输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * */
public class PrintListFromTailToHead {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (listNode != null) {
            arrayList.add(listNode.val);
            listNode = listNode.next;
        }
        int i = 0;
        int j = arrayList.size() - 1;
        int temp;
        while (i < j) {
            temp = arrayList.get(i);
            arrayList.set(i, arrayList.get(j));
            arrayList.set(j, temp);
            i++;
            j--;
        }
        return arrayList;
    }
}
