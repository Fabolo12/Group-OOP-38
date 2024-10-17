package module1.lecture17;

public class MyLinkedList<T> {
    Node head;

    Node tail;

    public static void main(String[] args) {
        final MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Hello");
        list.add("Hello2");
    }

    public void add(final T value) {
        final Node node = new Node(value, null, tail);
        if (head != null) {
            head.next = node;
        }
        head = node;

        if (tail == null) {
            tail = node;
        }
    }

    class Node {
        T value;

        Node next;

        Node prev;

        public Node(final T value, final Node next, final Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
