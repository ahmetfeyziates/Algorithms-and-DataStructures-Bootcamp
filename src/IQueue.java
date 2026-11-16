public interface IQueue {
    int size();

    boolean isEmpty();

    int front() throws EmptyQueueException;

    void enqueue(int element);

    void dequeue() throws EmptyQueueException;
}

