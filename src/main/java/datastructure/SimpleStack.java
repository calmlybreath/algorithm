package datastructure;

import java.util.ArrayList;
import java.util.Stack;

/**
 * The type Simple stack.
 *
 * @param <E> the type parameter
 */
public class SimpleStack<E> {
    private static final int DEFUAL_CAPACITY = 7;
    private int capacityIncrement = 0;
    private int elementCount = 0;
    private Object[] elementData = {};

    /**
     * Instantiates a new Simple stack.
     */
    public SimpleStack() {
    }

    /**
     * Instantiates a new Simple stack.
     *
     * @param size          the size
     * @param incrementSize the increment size
     */
    public SimpleStack(int size, int incrementSize) {
        elementData = new Object[size];
        this.capacityIncrement = incrementSize;
    }

    /**
     * Push.
     *
     * @param item the item
     */
    public void push(E item) {
        ensureCapacity();
        elementData[elementCount] = item;
        elementCount++;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if (elementCount <= 0) {
            throw new OutOfMemoryError("empty stack");
        }
        Object item = elementData[elementCount - 1];
        elementCount--;
        return (E) item;
    }

    /**
     * ensure capacity,if not enough capacity，grow
     */
    private void ensureCapacity() {
        //如果还有剩余空间
        if (elementCount < elementData.length) {
            return;
        }
        int newCapacity;
        if (elementData.length < DEFUAL_CAPACITY) {
            newCapacity = DEFUAL_CAPACITY;
            grow(newCapacity);
        } else {
            int oldCapacity = elementData.length;
            newCapacity = capacityIncrement > 0 ?
                    oldCapacity + capacityIncrement : oldCapacity * 2;
            grow(newCapacity);
        }
    }

    public boolean empty() {
        return elementCount == 0;
    }

    public int getCapacity() {
        return elementData.length;
    }

    /**
     * grow stack and copy old elementData to new elementData
     *
     * @param newCapacity new capaCity
     */
    private void grow(int newCapacity) {
        Object[] newElementData = new Object[newCapacity];
        System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
        elementData = newElementData;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Object item : elementData) {
            builder.append(item).append("+");
        }
        return builder.toString();
    }
}
