package data.structure;

import java.util.LinkedList;

/**
 * 双向链表类
 * The type Simple linked list.
 *
 * @param <E> the type parameter
 */
public class SimpleLinkedList<E> {
    private Node<E> frist;
    private Node<E> last;
    private int size = 0;
    private int modCount = 0;
    private LinkedList a;

    /**
     * Instantiates a new Simple linked list.
     */
    public SimpleLinkedList() {
    }

    /**
     * Add.
     *
     * @param e the e
     */
    public void add(E e) {
        linkLast(e);
    }

    /**
     * Get e.
     *
     * @param index the index
     * @return the e
     */
    public E get(int index) {
        checkIndex(index);
        Node<E> target = frist;
        for (int i = 0; i < index; i++) {
            target = target.next;
        }
        return target.value;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index out of size");
        }
    }

    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            frist = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    private void linkFrist(E e) {
        final Node<E> f = frist;
        final Node<E> newNode = new Node<>(null, e, f);
        frist = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.pre = newNode;
        }
        size++;
        modCount++;
    }

    /**
     * Reverse.
     */
    public void reverse() {
        Node<E> fnode = frist;
        Node<E> node = frist;
        while (node != null) {
            Node<E> next = node.next;
            node.next = node.pre;
            node.pre = next;
            node = next;
        }
        frist = last;
        last = fnode;
    }

    /**
     * Unlink frist.
     */
    public void unlinkFrist() {
        if (frist == null) {
            return;
        }
        frist = frist.next;
        size--;
        modCount++;
    }

    /**
     * Unlink last.
     */
    public void unlinkLast() {
        if (last == null) {
            return;
        }
        last = last.pre;
        size--;
        modCount++;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<E> node = this.frist;
        int count = this.size;
        while (--count >= 0) {
            stringBuilder.append(node.value).append("+");
            node = node.next;
        }
        return stringBuilder.toString();
    }

    private static class Node<E> {
        /**
         * The Value.
         */
        E value;
        /**
         * The Pre.
         */
        Node<E> pre;
        /**
         * The Next.
         */
        Node<E> next;

        /**
         * Instantiates a new Node.
         *
         * @param pre  the pre
         * @param e    the e
         * @param next the next
         */
        Node(Node<E> pre, E e, Node<E> next) {
            this.value = e;
            this.pre = pre;
            this.next = next;
        }
    }
}
