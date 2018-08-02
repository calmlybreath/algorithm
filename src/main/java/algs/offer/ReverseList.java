package algs.offer;

/**
 * The type Reverse list.
 */
public class ReverseList {
    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     *
     * @param head the head
     * @return the list node
     */
    public ListNode reverselist(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //用三个变量存储三个元素
        ListNode frist = head;
        ListNode second = frist.next;
        ListNode third ;
        while (second.next != null) {
            third = second.next;
            second.next = frist;
            frist = second;
            second = third;
        }
        head.next = null;
        second.next = frist;
        return second;
    }

    /**
     * The type List node.
     */
    public class ListNode {
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
}
