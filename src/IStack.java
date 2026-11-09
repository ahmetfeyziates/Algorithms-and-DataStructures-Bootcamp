public interface IStack {
    int size();

    boolean empty();

    int top() throws StackEmptyException;

    void push(int element);

    void pop() throws StackEmptyException;
}