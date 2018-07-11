package datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * The type Simple binary tree.
 *
 * @param <T> the type parameter
 */
public class SimpleBinaryTree<T extends Comparable> {
    private Node<T> root;

    /**
     * Instantiates a new Simple binary tree.
     */
    public SimpleBinaryTree() {
    }

    /**
     * Instantiates a new Simple binary tree.
     *
     * @param element the value
     */
    public SimpleBinaryTree(T element) {
        this.root = new Node<>(null, element, null);
    }

    /**
     * Add.
     *
     * @param element the element
     */
    @SuppressWarnings("unchecked")
    public void add(T element) {
        Node<T> newNode = new Node<T>(null, element, null);
        if (root == null) {
            root = new Node<>(null, element, null);
            return;
        }
        Node<T> node = this.root;
        while (true) {
            if (element.compareTo(node.element) <= 0) {
                if (node.leftChildren == null) {
                    node.leftChildren = newNode;
                    return;
                }
                node = node.leftChildren;
            } else {
                if (node.rightChildren == null) {
                    node.rightChildren = newNode;
                    return;
                }
                node = node.rightChildren;
            }
        }
    }

    public void order() {
        Stack<Node<T>> nodeStack = new Stack<>();
        Node<T> node = this.root;
        while (node != null) {
            if (node.leftChildren != null) {
                nodeStack.push(node);
                node = node.leftChildren;
            } else {
                System.out.println(node.element);
                if (node.rightChildren != null) {
                    node = node.rightChildren;
                } else {
                    if (nodeStack.empty()) {
                        return;
                    }
                    while (!nodeStack.empty()) {
                        Node<T> father = nodeStack.pop();
                        System.out.println(father.element);
                        node = father.rightChildren;
                        if (node != null) {
                            break;
                        }
                    }
                }
            }
        }
    }

    public void preOrder() {
        Stack<Node<T>> stack = new Stack<>();
        Node<T> node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.leftChildren;
            }
            if (!stack.isEmpty()) {
                Node<T> pop = stack.pop();
                System.out.println("pop = " + pop.element);
                node = pop.rightChildren;
            }
        }
    }

    public void dfs() {
        LinkedList<Node<T>> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            System.out.println(node.element);
            if (node.leftChildren != null) {
                queue.add(node.leftChildren);
            }
            if (node.rightChildren != null) {
                queue.add(node.rightChildren);
            }
        }
    }

    /**
     * The type Node.
     *
     * @param <T> the type parameter
     */
    static class Node<T> {
        private T element;
        private Node<T> leftChildren;
        private Node<T> rightChildren;

        /**
         * Instantiates a new Node.
         *
         * @param leftChildren  the left children
         * @param element       the value
         * @param rightChildren the right children
         */
        Node(Node<T> leftChildren, T element, Node<T> rightChildren) {
            this.element = element;
            this.leftChildren = leftChildren;
            this.rightChildren = rightChildren;
        }

        /**
         * Gets value.
         *
         * @return the value
         */
        public T getValue() {
            return element;
        }

        /**
         * Sets value.
         *
         * @param value the value
         */
        public void setValue(T value) {
            this.element = value;
        }

        /**
         * Gets left children.
         *
         * @return the left children
         */
        public Node<T> getLeftChildren() {
            return leftChildren;
        }

        /**
         * Sets left children.
         *
         * @param leftChildren the left children
         */
        public void setLeftChildren(Node<T> leftChildren) {
            this.leftChildren = leftChildren;
        }

        /**
         * Gets right children.
         *
         * @return the right children
         */
        public Node<T> getRightChildren() {
            return rightChildren;
        }

        /**
         * Sets right children.
         *
         * @param rightChildren the right children
         */
        public void setRightChildren(Node<T> rightChildren) {
            this.rightChildren = rightChildren;
        }
    }
}
