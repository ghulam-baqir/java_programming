package structures;

public class LinkedStack {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public LinkedStack() {
        this.head = null;
        this.size = 0;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow!");
        }
        int poppedValue = head.data;
        head = head.next;
        size--;
        return poppedValue;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow!");
        }
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }
}
