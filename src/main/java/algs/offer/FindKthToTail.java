package algs.offer;

import java.util.NoSuchElementException;

/**
 * The type Find kth to tail.
 */
public class FindKthToTail {

    private ListNode head;
    private ListNode tail;

    public FindKthToTail(int value) {
        ListNode head = new ListNode(value);
        this.head = head;
        this.tail = this.head;
    }

    public void add(int value) {
        ListNode node = new ListNode(value);
        this.tail.next = node;
        this.tail = node;
    }


    /**
     * 输入一个链表，输出该链表中倒数第k个结点
     *
     * @param head the head
     * @param k    the k
     * @return the list node
     */
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        int index = 1;
        ListNode pre = head;
        while (pre.next != null && index < k) {
            pre = pre.next;
            index++;
        }
        if (index < k) {
            return null;
        }
        ListNode target = head;
        while (pre.next != null) {
            target = target.next;
            pre = pre.next;
        }
        return target;
    }

    /**
     * The type List node.
     */
    public class ListNode {
        public int getVal() {
            return val;
        }

        /**
         * The Val.
         */
        int val;
        /**
         * The Next.
         */
        ListNode next = null;

        /**
         * Instantiates a new List node.
         *
         * @param val the val
         */
        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        FindKthToTail findKthToTail = new FindKthToTail(1);
        for (int i = 2; i < 6; i++) {
            findKthToTail.add(i);
        }
    }
}
