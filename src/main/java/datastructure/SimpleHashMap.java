package datastructure;

/**
 * The type Simple hash map.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
public class SimpleHashMap<K, V> {
    /**
     * hash table
     */
    private Node<K, V>[] table;

    private static final int DEFAULT_CAPACITY = 14;

    private int size;

    /**
     * Put.
     *
     * @param key   the key
     * @param value the value
     * @return the v
     */
    public V put(K key, V value) {
        ensureCapacity(); //保证大小

        Node<K, V> newNode = new Node<>(hash(key), key, value, null); //实例化新节点

        //1、根据key计算出index
        int index = index(key);
        //2、遍历改index里的链表，如果存在key与新插入的key相同，则替换
        Node<K, V> headNode = table[index];
        //如果头节点为null,或者只有一个元素，直接插入
        if (headNode == null || headNode.next == null) {
            table[index] = newNode;
            return value;
        } else {
            Node<K, V> next = headNode;
            Node<K, V> oldNext = next;
            while (next != null) {
                if (next.equals(key)) {
                    oldNext.next = newNode;
                    newNode.next = next.next;
                    return value;
                }
                oldNext = next;
                next = next.next;
            }
            //3、不存在，则在链表尾部添加新插入的这个节点
            oldNext.next = newNode;
            size++;
            return value;
        }
    }

    /**
     * Get v.
     *
     * @param key the key
     * @return the v
     */
    public V get(K key) {
        int index = index(key);
        Node<K, V> node = table[index];
        while (node != null) {
            if (node.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (table == null) {
            table = new Node[DEFAULT_CAPACITY];
        }
    }

    /**
     * calculate the index by key
     *
     * @return the int
     */
    private int index(K key) {
        return 0;
    }

    /**
     * Hash.
     *
     * @param key the key
     * @return the int
     */
    private int hash(K key) {
        return 0;

    }

    /**
     * The type Node.
     *
     * @param <K> the type parameter
     * @param <V> the type parameter
     * @author lrq key value node
     */
    static class Node<K, V> {
        private int hash;
        private K key;
        private V value;
        private Node<K, V> next;

        /**
         * Instantiates a new Node.
         *
         * @param hash  the hash
         * @param key   the key
         * @param value the value
         * @param next  the next
         */
        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
