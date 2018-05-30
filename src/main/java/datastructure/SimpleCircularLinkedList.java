package datastructure;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * 双向循环链表（作为队列使用）
 *
 * @param <E> the type parameter
 * @author lrq
 */
public class SimpleCircularLinkedList<E> {
    private int size;
    private Node<E> head;

    /**
     * Instantiates a new Circular linked list.
     */
    public SimpleCircularLinkedList() {
        size = 0;
    }

    /**
     * Instantiates a new Circular linked list.
     *
     * @param value the value
     */
    public SimpleCircularLinkedList(E value) {
        head = new Node<>(value);
        head.pre = head;
        head.next = head;
        size++;
    }

    private void initHead(Node<E> head) {
        head.pre = head;
        head.next = head;
        this.head = head;
    }

    private void insertBefore(Node<E> nextNode, Node<E> newNode) {
        Node<E> oldPreviousNode = nextNode.pre;
        oldPreviousNode.next = newNode;
        newNode.pre = oldPreviousNode;
        newNode.next = nextNode;
        nextNode.pre = newNode;
    }

    private void insertAfter(Node<E> previousNode, Node<E> newNode) {
        Node<E> oldNextNode = previousNode.next;
        oldNextNode.pre = newNode;
        newNode.pre = previousNode;
        newNode.next = oldNextNode;
        previousNode.next = newNode;
    }

    /**
     * Link last.
     *
     * @param value the value
     */
    private void linkLast(E value) {
        Node<E> node = new Node<>(value);
        if (head == null) {
            initHead(node);
        } else {
            Node<E> previousNode = head.pre;
            insertAfter(previousNode, node);
        }
        size++;
    }

    /**
     * Unlink last.
     *
     * @return the e
     */
    private E unlinkLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<E> oldLast = head.pre;
        if (oldLast == head) {
            //如果只有头部
            head = null;
        } else {
            Node<E> newLast = oldLast.pre;
            newLast.next = head;
            head.pre = newLast;
        }
        size--;
        return oldLast.value;
    }

    /**
     * Unlink frist.
     *
     * @return the e
     */
    private E unlinkFrist() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<E> last = head.pre;
        Node<E> oldHead = this.head;
        if (last == this.head) {
            //如果只有头部
            this.head = null;
        } else {
            Node<E> newHead = oldHead.next;
            newHead.pre = last;
            last.next = newHead;
            head = newHead;
        }
        size--;
        return oldHead.value;
    }

    /**
     * Add element to queue
     *
     * @param value the value
     */
    public void add(E value) {
        linkLast(value);
    }

    /**
     * Poll e.
     *
     * @return the e
     */
    public E poll() {
        return unlinkFrist();
    }

    /**
     * Peek e.
     *
     * @return the e
     */
    public E peek() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.value;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return size < 1;
    }

    @Override
    public String toString() {
        Node<E> node = this.head;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(node.value).append(" ");
            node = node.next;
        }
        return stringBuilder.toString();
    }

    /**
     * The type Node.
     *
     * @param <E> the type parameter
     */
    private static class Node<E> {
        private E value;
        private Node<E> pre;
        private Node<E> next;

        /**
         * Instantiates a new Node.
         *
         * @param value the value
         */
        Node(E value) {
            this(null, value, null);
        }

        /**
         * Instantiates a new Node.
         *
         * @param pre   the pre
         * @param value the value
         * @param next  the next
         */
        Node(Node<E> pre, E value, Node<E> next) {
            this.pre = pre;
            this.value = value;
            this.next = next;
        }
    }
}
