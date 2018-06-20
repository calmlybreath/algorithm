package datastructure;

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
