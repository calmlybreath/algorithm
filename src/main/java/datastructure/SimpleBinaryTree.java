package datastructure;

import java.util.LinkedList;
import java.util.NoSuchElementException;
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
    public Node<T> add(T element) {
        Node<T> newNode = new Node<T>(null, element, null);
        if (root == null) {
            root = new Node<>(null, element, null);
            return null;
        }
        Node<T> node = this.root;
        while (true) {
            if (element.compareTo(node.element) <= 0) {
                if (node.leftChildren == null) {
                    node.leftChildren = newNode;
                    return node;
                }
                node = node.leftChildren;
            } else {
                if (node.rightChildren == null) {
                    node.rightChildren = newNode;
                    return node;
                }
                node = node.rightChildren;
            }
        }
    }

    /*
     *   查找节点，并返回父节点，当目标节点是root时，返回null
     * */
    @SuppressWarnings("unchecked")
    public NodeInfo<T> find(T element) {
        if (root == null) {
            throw new NoSuchElementException();
        }
        Node<T> parentNode = null;
        Node<T> currentNode = root;
        boolean isLeft = false;
        while (currentNode != null) {
            if (element.compareTo(currentNode.element) < 0) {
                parentNode = currentNode;
                currentNode = currentNode.leftChildren;
                isLeft = true;
            } else if (element.compareTo(currentNode.element) > 0) {
                parentNode = currentNode;
                currentNode = currentNode.rightChildren;
                isLeft = false;
            } else {
                return new NodeInfo<>(parentNode, currentNode, isLeft);
            }
        }
        throw new NoSuchElementException();
    }

    public void remove(T element) {
        NodeInfo<T> nodeInfo = find(element);
        Node<T> willBeDeletedNode = nodeInfo.getCurrentNode();
        //1、如果没有左右孩子
        if (willBeDeletedNode.leftChildren == null && willBeDeletedNode.rightChildren == null) {
            //如果是根节点
            if(nodeInfo.parentNode==null){
                root=null;
                return;
            }
            if(nodeInfo.isLeft){
                nodeInfo.parentNode.leftChildren=null;
            }else {
                nodeInfo.parentNode.rightChildren=null;
            }
            return;
        }
        //2、有一个孩子时
        if (willBeDeletedNode.leftChildren == null && willBeDeletedNode.rightChildren != null) {
            Node<T> parent;
            if (nodeInfo.getParentNode() == null) {
                parent = root;
            } else {
                parent = nodeInfo.getParentNode();
            }
            if (nodeInfo.isLeft) {
                parent.leftChildren = willBeDeletedNode.leftChildren;
            } else {
                parent.rightChildren = willBeDeletedNode.rightChildren;
            }
        }
        if (willBeDeletedNode.leftChildren != null && willBeDeletedNode.rightChildren == null) {
            Node<T> parent;
            if (nodeInfo.getParentNode() == null) {
                parent = root;
            } else {
                parent = nodeInfo.getParentNode();
            }
            if (!nodeInfo.isLeft) {
                parent.rightChildren = willBeDeletedNode.leftChildren;
            } else {
                parent.leftChildren = willBeDeletedNode.rightChildren;
            }
        }

        //3 如果目标节点有两个孩子,寻找左字树最大的元素
        Node<T> maxChild = findAndMoveMaxChild(willBeDeletedNode.leftChildren);
        if (nodeInfo.parentNode == null) {
            maxChild.leftChildren = willBeDeletedNode.leftChildren;
            maxChild.rightChildren = willBeDeletedNode.rightChildren;
            root=maxChild;
        } else {
            maxChild.rightChildren=willBeDeletedNode.rightChildren;
            if (nodeInfo.isLeft) {
                nodeInfo.parentNode.leftChildren = maxChild;
            } else {
                nodeInfo.parentNode.rightChildren = maxChild;
            }
        }
    }

    private Node<T> findAndMoveMaxChild(Node<T> node) {
        if (node.rightChildren == null) {
            return node;
        }
        Node<T> parentNode = null;
        Node<T> currentNode = node;
        while (currentNode.rightChildren != null) {
            parentNode = currentNode;
            currentNode = currentNode.rightChildren;
        }
        parentNode.rightChildren = null;
        return currentNode;
    }

    /*
     *  深度遍历
     * */
    public void dfs() {
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

    /*
     * 广度遍历
     * */
    public void bfs() {
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
    public static class Node<T> {
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

    public static class NodeInfo<T> {
        private Node<T> parentNode;
        private Node<T> currentNode;
        private boolean isLeft;

        public NodeInfo(Node<T> parentNode, Node<T> currentNode, boolean isLeft) {
            this.parentNode = parentNode;
            this.currentNode = currentNode;
            this.isLeft = isLeft;
        }

        public Node<T> getParentNode() {
            return parentNode;
        }

        public Node<T> getCurrentNode() {
            return currentNode;
        }
    }
}
