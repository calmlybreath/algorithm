package datastructure;

/**
 * The type Simple array list.
 *
 * @author lrq
 * @date 2018
 */
public class SimpleArrayList<E> {
    private static final int DEFAUTL_CAPACITY = 10;
    private Object[] elementData;

    /**
     * 当前数组大小
     **/
    private int size;
    private int modCount;

    public int getCapacity() {
        return elementData.length;
    }

    /**
     * Instantiates a new Simple array list.
     */
    public SimpleArrayList() {
        elementData = new Object[DEFAUTL_CAPACITY];
    }

    /**
     * Instantiates a new Simple array list.
     *
     * @param capacity the capacity
     */
    public SimpleArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("容量不能小于0");
        }
        elementData = new Object[capacity];
    }

    /**
     * @param e
     */
    public void add(E e) {
        //检查数组容量
        ensureCapacity();
        elementData[size] = e;
        size++;
        modCount++;
    }

    /**
     *
     */
    private void ensureCapacity() {
        if (elementData.length <= size) {
            grow();
        }
    }

    private void grow() {
        //计算newCapacity
        int newCapacity;
        if (elementData.length < DEFAUTL_CAPACITY) {
            newCapacity = DEFAUTL_CAPACITY;
        } else {
            newCapacity = elementData.length << 1;
        }
        elementData = copy(elementData, newCapacity);
    }

    /**
     * @param src
     * @param newCapacity
     * @return newObject
     */
    private Object[] copy(Object[] src, int newCapacity) {
        Object[] newObject = new Object[newCapacity];
        System.arraycopy(src, 0, newObject, 0, src.length);
        return newObject;
    }


    /**
     * @param index
     * @return E
     */
    public E get(int index) {
        //检查索引
        checkIndex(index);
        //返回
        return elementData(index);

    }

    public void removeBatch(int from, int to) {
        checkIndex(from, to);
        int preStart = from;
        int backStart = to + 1;
        for (int i = backStart; i < size; i++) {
            elementData[preStart] = elementData[backStart];
            preStart++;
            backStart++;
        }
        size = size - (to - from + 1);
    }


    @SuppressWarnings("unchecked")
    private E elementData(int index) {
        return ((E) elementData[index]);
    }

    /**
     * @param index
     */
    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("index error");
        }
    }

    /**
     * @param from
     * @param to hh
     * @throws IllegalArgumentException j
     */
    private void checkIndex(int from, int to) {
        if (from > to) {
            throw new IllegalArgumentException("parameter illegal");
        }
        checkIndex(from);
        checkIndex(to);
    }

    @Override
    @SuppressWarnings("unchecked")
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object[] dumpArray=elementData;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(((E) dumpArray[i]));
            stringBuilder.append('+');
        }
        return stringBuilder.toString();
    }
}
