package datastructure;

/**
 * The type Simple hash map.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
public class SimpleHashMap<K, V> {

    /**
     * Put.
     *
     * @param key   the key
     * @param value the value
     */
    public void put(K key, V value) {
        //1、根据key计算出index
        //2、遍历改index里的链表，如果存在key与新插入的key相同，则替换
        //3、不存在，则在链表尾部添加新插入的这个节点
    }

    /**
     * calculate the index by key
     *
     * @return the int
     */
    public int index(K key) {
        return 0;
    }

    public void hash(K key) {


    }

    /**
     * @author lrq
     * key value node
     */
    private static class Node<K, V> {
        private K key;
        private V value;

        /**
         * Instantiates a new Node.
         *
         * @param key   the key
         * @param value the value
         */
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
