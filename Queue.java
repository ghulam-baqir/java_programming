class Queue {
    int[] data;
    int front;
    int rear;

    Queue(int size) {
        data = new int[size];
        front = 0;
        rear = -1;
    }

    void enqueue(int value) {
        if (rear == data.length - 1) {
            System.out.println("Queue is full");
            return;
        }

        rear++;
        data[rear] = value;
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        int value = data[front];
        front++;
        return value;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return data[front];
    }

    boolean isEmpty() {
        return front > rear;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        for (int i = front; i <= rear; i++) {
            System.out.print(data[i] + " ");
        }

        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        Queue q = new Queue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        System.out.println("Queue:");
        q.display();

        System.out.println("Front element: " + q.peek());

        System.out.println("Removed: " + q.dequeue());

        System.out.println("Queue after dequeue:");
        q.display();
    }
}