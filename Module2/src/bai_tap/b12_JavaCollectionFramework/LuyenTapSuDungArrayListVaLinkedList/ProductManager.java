package b12_JavaCollectionFramework.LuyenTapSuDungArrayListVaLinkedList;

import java.util.Arrays;

public class ProductManager<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public ProductManager() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public ProductManager(int capacity){};

    public void ensureCapacity(int minCapacity) {
        Object newElements[] = new Object[minCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }

        elements = newElements;
    }

    public void add(int index, E element) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " don't correct");
        }

        if (size == elements.length) {
            ensureCapacity(elements.length * 2);
        }

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " don't correct");
        }

        E result = (E)elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        elements[size] = null;
        return result;
    }

    public int size() {
        return size;
    }

    public ProductManager<E> clone() {
        ProductManager<E> newList = new ProductManager<>(elements.length);
        for (int i = 0; i < size; i++) {
            newList.elements[i] = elements[i];
        }
        newList.size = size;
        return newList;
    }

    public boolean contain(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " don't correct");
        }
        return (E)elements[index];
    }

    public void clear() {
        size = 0;
        elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public String toString() {
        return "ProductManager{" + "size=" + size + ", elements=" + Arrays.toString(elements) + '}';
    }
}
