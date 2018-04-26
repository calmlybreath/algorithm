package data.structure;

import java.util.LinkedList;

public class SimpleLinkedList<E> {
    private Node<E> frist;
    private Node<E> last;
    private int size = 0;
    private int modCount = 0;
    private LinkedList a;

    public SimpleLinkedList() {
    }

    public void add(E e) {
        linkLast(e);
    }

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

    public void unlinkFrist() {
        if (frist == null) {
            return;
        }
        frist = frist.next;
        size--;
    }

    public void unlinkLast() {
        if (last == null) {
            return;
        }
        last = last.pre;
        size--;
    }

    private static class Node<E> {
        E value;
        Node<E> pre;
        Node<E> next;

        Node(Node<E> pre, E e, Node<E> next) {
            this.value = e;
            this.pre = pre;
            this.next = next;
        }
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
}
