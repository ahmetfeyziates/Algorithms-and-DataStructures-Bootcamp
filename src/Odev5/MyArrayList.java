import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

public class MyArrayList extends AbstractList<String> implements RandomAccess {
    private static final int INITIAL_CAPACITY = 10;

    private String[] elements;
    private int size;

    public MyArrayList() {
        elements = new String[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String get(int index) {
        checkElementIndex(index);
        return elements[index];
    }

    @Override
    public String set(int index, String element) {
        checkElementIndex(index);

        String previous = elements[index];
        elements[index] = element;
        return previous;
    }

    @Override
    public void add(int index, String element) {
        checkPositionIndex(index);
        ensureCapacityForOneMore();

        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
        modCount++;
    }

    @Override
    public String remove(int index) {
        checkElementIndex(index);

        String removed = elements[index];
        int elementsToMove = size - index - 1;

        if (elementsToMove > 0) {
            System.arraycopy(elements, index + 1, elements, index, elementsToMove);
        }

        elements[--size] = null;
        modCount++;
        return removed;
    }

    @Override
    public void clear() {
        if (size > 0) {
            Arrays.fill(elements, 0, size, null);
            size = 0;
            modCount++;
        }
    }

    private void ensureCapacityForOneMore() {
        if (size < elements.length) {
            return;
        }

        if (size == Integer.MAX_VALUE) {
            throw new OutOfMemoryError("List is too large");
        }

        long grownCapacity = (long) elements.length + elements.length / 2 + 1;
        int newCapacity = (int) Math.min(grownCapacity, Integer.MAX_VALUE);
        elements = Arrays.copyOf(elements, newCapacity);
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", size: " + size
            );
        }
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", size: " + size
            );
        }
    }
}
