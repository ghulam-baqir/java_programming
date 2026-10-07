import java.util.*;

public class QueuePractice {

    static class ArrayQueue {
        private final int[] data;
        private int front = 0, size = 0;

        ArrayQueue(int capacity) { data = new int[capacity]; }

        boolean isEmpty() { return size == 0; }
        boolean isFull() { return size == data.length; }
        int size() { return size; }

        void enqueue(int x) {
            if (isFull()) throw new IllegalStateException("Queue is full");
            data[(front + size) % data.length] = x;
            size++;
        }

        int dequeue() {
            if (isEmpty()) throw new NoSuchElementException("Queue is empty");
            int x = data[front];
            front = (front + 1) % data.length;
            size--;
            return x;
        }

        int peek() {
            if (isEmpty()) throw new NoSuchElementException("Queue is empty");
            return data[front];
        }
    }

    static class LinkedQueue {
        private static class Node {
            int val;
            Node next;
            Node(int val) { this.val = val; }
        }

        private Node head, tail;
        private int size = 0;

        boolean isEmpty() { return head == null; }
        int size() { return size; }

        void enqueue(int x) {
            Node node = new Node(x);
            if (tail == null) head = tail = node;
            else { tail.next = node; tail = node; }
            size++;
        }

        int dequeue() {
            if (isEmpty()) throw new NoSuchElementException("Queue is empty");
            int x = head.val;
            head = head.next;
            if (head == null) tail = null;
            size--;
            return x;
        }

        int peek() {
            if (isEmpty()) throw new NoSuchElementException("Queue is empty");
            return head.val;
        }
    }

    static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty()) stack.push(q.poll());
        while (!stack.isEmpty()) q.offer(stack.pop());
    }

    static List<String> generateBinary(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.offer("1");
        for (int i = 0; i < n; i++) {
            String s = q.poll();
            result.add(s);
            q.offer(s + "0");
            q.offer(s + "1");
        }
        return result;
    }

    static String firstNonRepeating(String stream) {
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : stream.toCharArray()) {
            freq[c - 'a']++;
            q.offer(c);
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) q.poll();
            sb.append(q.isEmpty() ? '#' : q.peek());
        }
        return sb.toString();
    }

    static class QueueUsingStacks {
        private final Stack<Integer> in = new Stack<>();
        private final Stack<Integer> out = new Stack<>();

        void push(int x) { in.push(x); }

        int pop() { move(); return out.pop(); }

        int peek() { move(); return out.peek(); }

        boolean isEmpty() { return in.isEmpty() && out.isEmpty(); }

        private void move() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) out.push(in.pop());
            }
        }
    }

    static class StackUsingQueue {
        private final Queue<Integer> q = new LinkedList<>();

        void push(int x) {
            q.offer(x);
            for (int i = 0; i < q.size() - 1; i++) q.offer(q.poll());
        }

        int pop() {
            if (q.isEmpty()) throw new NoSuchElementException("Stack is empty");
            return q.poll();
        }

        int top() {
            if (q.isEmpty()) throw new NoSuchElementException("Stack is empty");
            return q.peek();
        }

        boolean isEmpty() { return q.isEmpty(); }
    }

    static void reverseFirstK(Queue<Integer> q, int k) {
        if (k <= 0 || k > q.size()) return;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) stack.push(q.poll());
        while (!stack.isEmpty()) q.offer(stack.pop());
        int remaining = q.size() - k;
        for (int i = 0; i < remaining; i++) q.offer(q.poll());
    }

    static int josephus(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) q.offer(i);
        while (q.size() > 1) {
            for (int i = 0; i < k - 1; i++) q.offer(q.poll());
            q.poll();
        }
        return q.peek();
    }

    static int[] slidingWindowMax(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k <= 0) return new int[0];
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast();
            dq.offerLast(i);
            if (i >= k - 1) result[i - k + 1] = nums[dq.peekFirst()];
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(3);
        aq.enqueue(10);
        aq.enqueue(20);
        aq.enqueue(30);
        System.out.println("P1 full? " + aq.isFull());
        System.out.println("P1 dequeue: " + aq.dequeue());
        aq.enqueue(40);
        System.out.println("P1 peek: " + aq.peek() + ", size: " + aq.size());

        LinkedQueue lq = new LinkedQueue();
        lq.enqueue(1);
        lq.enqueue(2);
        lq.enqueue(3);
        System.out.println("P2 dequeue: " + lq.dequeue());
        System.out.println("P2 peek: " + lq.peek() + ", size: " + lq.size());

        Queue<Integer> q3 = new LinkedList<>(Arrays.asList(1, 2, 3, 4));
        reverseQueue(q3);
        System.out.println("P3 reversed: " + q3);

        System.out.println("P4 binary 1..5: " + generateBinary(5));

        System.out.println("P5 \"aabc\": " + firstNonRepeating("aabc"));

        QueueUsingStacks qs = new QueueUsingStacks();
        qs.push(1);
        qs.push(2);
        qs.push(3);
        System.out.println("P6 pop: " + qs.pop());
        qs.push(4);
        System.out.println("P6 peek: " + qs.peek() + ", pop: " + qs.pop());

        StackUsingQueue su = new StackUsingQueue();
        su.push(1);
        su.push(2);
        su.push(3);
        System.out.println("P7 top: " + su.top());
        System.out.println("P7 pop: " + su.pop() + ", then pop: " + su.pop());

        Queue<Integer> q8 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        reverseFirstK(q8, 3);
        System.out.println("P8 reverse first 3: " + q8);

        System.out.println("P9 josephus(5, 2): " + josephus(5, 2));
        System.out.println("P9 josephus(7, 3): " + josephus(7, 3));

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println("P10 sliding max (k=3): " + Arrays.toString(slidingWindowMax(nums, 3)));
    }
}