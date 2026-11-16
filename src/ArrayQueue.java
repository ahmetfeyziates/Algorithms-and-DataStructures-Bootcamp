public class ArrayQueue implements IQueue {
    private final int[] elements;
    private int frontIndex;
    private int rearIndex;
    private int size;

    public ArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }

        elements = new int[capacity];
        frontIndex = 0;
        rearIndex = 0;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int front() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        }

        return elements[frontIndex];
    }

    @Override
    public void enqueue(int element) {
        if (size == elements.length) {
            throw new IllegalStateException("Queue is full");
        }

        elements[rearIndex] = element;
        rearIndex = (rearIndex + 1) % elements.length;
        size++;
    }

    @Override
    public void dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        }

        frontIndex = (frontIndex + 1) % elements.length;
        size--;
    }
}
