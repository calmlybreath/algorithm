package datastructure;

import java.util.NoSuchElementException;

/**
 * 最大堆
 *
 * @param <T> the type parameter
 */
public class SimpleHeap<T extends Comparable> {
    //
    private Object[] heap;

    public int getSize() {
        return size;
    }

    private int size = 0;
    private static final int DEFAULT_SIZE = 10;

    /**
     * Instantiates a new Simple heap.
     */
    public SimpleHeap() {
        this.heap = new Object[DEFAULT_SIZE];
    }

    /**
     * Instantiates a new Simple heap.
     *
     * @param size the size
     */
    public SimpleHeap(int size) {
        this.heap = new Object[size];
    }

    @SuppressWarnings("unchecked")
    public void add(T element) {
        //1、确保空间充足
        ensureCapacity();
        //2、将元素添加到数组末尾
        heap[size] = element;
        size++;
        //3、调整结构，使其符合最大堆的结构
        int currentIndex = size - 1;
        int parentIndex;
        while (currentIndex != 0 && (parentIndex = getParentIndex(currentIndex)) >= 0) {
            if (((T) heap[parentIndex]).compareTo(((T) heap[currentIndex])) >= 0) {
                return;
            }
            //swap
            Object temp = heap[parentIndex];
            heap[parentIndex] = heap[currentIndex];
            heap[currentIndex] = temp;
            currentIndex = parentIndex;
        }
    }

    @SuppressWarnings("unchecked")
    public T get() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else if (size == 1) {
            //如果只有一个元素
            size--;
            Object ret = heap[0];
            heap[0] = null;
            return (T) ret;
        }


        size--;
        Object headElement = heap[0];
        int tempSize = size;
        //首部元素替换成尾部元素
        heap[0] = heap[tempSize];
        heap[tempSize] = null;
        //自顶向下调整
        int parentIndex = 0;
        int leftIndex, rightIndex;
        while ((leftIndex = getLeftChildIndex(parentIndex)) < tempSize) {
            int max;
            if ((rightIndex = getRightChildIndex(parentIndex)) < tempSize) {
                if (((T) heap[leftIndex]).compareTo(((T) heap[rightIndex])) <= 0) {
                    max = rightIndex;
                } else {
                    max = leftIndex;
                }
            } else {
                max = leftIndex;
            }
            if (((T) heap[parentIndex]).compareTo((T) heap[max]) < 0) {
                Object temp = heap[max];
                heap[max] = heap[parentIndex];
                heap[parentIndex] = temp;
                parentIndex = max;
            } else {
                return (T) headElement;
            }
        }
        return (T) headElement;
    }

    private void ensureCapacity() {
        if (heap.length > size) {
            return;
        }
        Object[] newHead;
        if (heap.length < DEFAULT_SIZE) {
            newHead = new Object[DEFAULT_SIZE];
        } else {
            newHead = new Object[heap.length * 2];
        }

        System.arraycopy(heap, 0, newHead, 0, heap.length);
        heap = newHead;
    }


    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }
}
