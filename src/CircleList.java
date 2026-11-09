import java.util.NoSuchElementException;

public class CircleList {
    private static class Node {
        private final String element;
        private Node next;

        private Node(String element) {
            this.element = element;
        }
    }

    private Node cursor;

    public CircleList() {
        cursor = null;
    }

    public boolean empty() {
        return cursor == null;
    }

    // Returns the element at the cursor.
    public String front() {
        requireNonEmpty();
        return cursor.element;
    }

    // Returns the element immediately after the cursor.
    public String back() {
        requireNonEmpty();
        return cursor.next.element;
    }

    public void advance() {
        requireNonEmpty();
        cursor = cursor.next;
    }

    // Inserts a node immediately after the cursor.
    public void add(String element) {
        Node node = new Node(element);

        if (empty()) {
            node.next = node;
            cursor = node;
        } else {
            node.next = cursor.next;
            cursor.next = node;
        }
    }

    // Removes the node immediately after the cursor.
    public void remove() {
        requireNonEmpty();

        if (cursor.next == cursor) {
            cursor = null;
        } else {
            cursor.next = cursor.next.next;
        }
    }

    private void requireNonEmpty() {
        if (empty()) {
            throw new NoSuchElementException("The circular list is empty");
        }
    }
}
