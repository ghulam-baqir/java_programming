package structures;

public class ArrayStack {
    private int[] data;
    private int top;
    private int capacity;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        this.top = -1;
    }

    public void push(int value) {
        if (top == capacity - 1) {
            throw new RuntimeException("Stack Overflow: Stack Full Hai!");
        }
        data[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow: Stack Empty Hai!");
        }
        return data[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow: Stack Empty Hai!");
        }
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}
