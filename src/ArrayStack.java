import java.util.Arrays;

public class ArrayStack implements IStack {
    private static final int INITIAL_CAPACITY = 10;

    private int[] elements;
    private int size;

    public ArrayStack() {
        elements = new int[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public int top() {
        if (empty()) {
            throw new StackEmptyException("Stack is empty");
        }
        return elements[size - 1];
    }

    @Override
    public void push(int element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[size++] = element;
    }

    @Override
    public void pop() {
        if (empty()) {
            throw new StackEmptyException("Stack is empty");
        }
        size--;
    }
}