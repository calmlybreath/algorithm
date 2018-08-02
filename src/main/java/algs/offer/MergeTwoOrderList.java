package algs.offer;

/**
 * The type Merge two order list.
 */
public class MergeTwoOrderList {

    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     *
     * @param list1 the list 1
     * @param list2 the list 2
     * @return the list node
     */
    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode mergeHead = null;
        ListNode mergeNode = null;
        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode currentNode;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                currentNode = node1;
                node1 = node1.next;
            } else {
                currentNode = node2;
                node2 = node2.next;
            }
            if (mergeHead == null) {
                mergeHead = currentNode;
                mergeNode = currentNode;
            } else {
                mergeNode.next = currentNode;
                mergeNode = mergeNode.next;
            }
        }

        //不存在list1和list2同时被遍历完的情况
        //如果list1先被遍历完
        if (node1 == null) {
            while (node2 != null) {
                mergeNode.next = node2;
                mergeNode = mergeNode.next;
                node2 = node2.next;

            }
        } else {
            while (node1 != null) {
                mergeNode.next = node1;
                mergeNode = mergeNode.next;
                node1 = node1.next;

            }
        }

        return mergeHead;
    }

    /**
     * Test.
     */
    public void test() {
        ListNode list1, list2;
        list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        ListNode merge = merge(list1, list2);
        while (merge != null) {
            System.out.println("merge = " + merge.val);
            merge = merge.next;
        }
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

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        MergeTwoOrderList mergeTwoOrderList = new MergeTwoOrderList();
        mergeTwoOrderList.test();
    }

}
