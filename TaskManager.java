/* TaskManager.java — To-Do / Task Manager using a Singly Linked List */

import java.util.Scanner;

public class TaskManager {

    /* ---------- data ---------- */

    static class Task {
        int    id;
        String title;
        String priority;   // "High", "Medium", "Low"
        boolean done;

        Task(int id, String title, String priority) {
            this.id       = id;
            this.title    = title;
            this.priority = priority;
            this.done     = false;
        }

        @Override
        public String toString() {
            String status = done ? "[✓]" : "[ ]";
            return String.format("%s #%d  %-25s  (%s)", status, id, title, priority);
        }
    }

    static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
        }
    }

    /* ---------- linked list state ---------- */

    private Node head;
    private int  size;
    private int  nextId;   // auto-increment id

    public TaskManager() {
        head   = null;
        size   = 0;
        nextId = 1;
    }

    /* ---------- core operations ---------- */

    /** Add a new task at the end of the list. */
    public void addTask(String title, String priority) {
        Task t = new Task(nextId++, title, priority);
        Node n = new Node(t);

        if (head == null) {
            head = n;
        } else {
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = n;
        }
        size++;
        System.out.println("Added: " + t);
    }

    /** Find a node by task id. Returns null if not found. */
    private Node findById(int id) {
        Node cur = head;
        while (cur != null) {
            if (cur.task.id == id) return cur;
            cur = cur.next;
        }
        return null;
    }

    /** Remove a task by id. */
    public boolean removeTask(int id) {
        if (head == null) return false;

        if (head.task.id == id) {          // removing head
            System.out.println("Removed: " + head.task);
            head = head.next;
            size--;
            return true;
        }

        Node cur = head;
        while (cur.next != null && cur.next.task.id != id) {
            cur = cur.next;
        }

        if (cur.next == null) return false; // not found

        System.out.println("Removed: " + cur.next.task);
        cur.next = cur.next.next;
        size--;
        return true;
    }

    /** Mark a task as done (or undo if already done). */
    public void toggleDone(int id) {
        Node n = findById(id);
        if (n == null) {
            System.out.println("Task #" + id + " not found.");
            return;
        }
        n.task.done = !n.task.done;
        System.out.println("Updated: " + n.task);
    }

    /** Print all tasks. */
    public void showAll() {
        System.out.println("\n--- All Tasks (" + size + ") ---");
        if (head == null) {
            System.out.println("  (empty)");
            return;
        }
        Node cur = head;
        while (cur != null) {
            System.out.println("  " + cur.task);
            cur = cur.next;
        }
    }

    /** Print only pending tasks. */
    public void showPending() {
        System.out.println("\n--- Pending Tasks ---");
        Node cur = head;
        boolean any = false;
        while (cur != null) {
            if (!cur.task.done) {
                System.out.println("  " + cur.task);
                any = true;
            }
            cur = cur.next;
        }
        if (!any) System.out.println("  (nothing pending 🎉)");
    }

    /** Print only completed tasks. */
    public void showCompleted() {
        System.out.println("\n--- Completed Tasks ---");
        Node cur = head;
        boolean any = false;
        while (cur != null) {
            if (cur.task.done) {
                System.out.println("  " + cur.task);
                any = true;
            }
            cur = cur.next;
        }
        if (!any) System.out.println("  (none completed yet)");
    }

    /* ---------- interactive menu ---------- */

    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        Scanner sc = new Scanner(System.in);

        // kuch demo tasks
        tm.addTask("Buy groceries",       "Medium");
        tm.addTask("Finish LL project",   "High");
        tm.addTask("Call mom",            "Low");

        while (true) {
            System.out.println("\n===== TASK MANAGER =====");
            System.out.println("1. Add task");
            System.out.println("2. Remove task");
            System.out.println("3. Mark done / undo");
            System.out.println("4. Show all tasks");
            System.out.println("5. Show pending");
            System.out.println("6. Show completed");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine().trim();
                    System.out.print("Priority (High/Medium/Low): ");
                    String pri = sc.nextLine().trim();
                    if (title.isEmpty()) title = "(untitled)";
                    if (pri.isEmpty())   pri   = "Medium";
                    tm.addTask(title, pri);
                    break;

                case 2:
                    System.out.print("Task id to remove: ");
                    try {
                        int rid = Integer.parseInt(sc.nextLine().trim());
                        if (!tm.removeTask(rid))
                            System.out.println("Task #" + rid + " not found.");
                    } catch (Exception e) {
                        System.out.println("Invalid id.");
                    }
                    break;

                case 3:
                    System.out.print("Task id to toggle done: ");
                    try {
                        int tid = Integer.parseInt(sc.nextLine().trim());
                        tm.toggleDone(tid);
                    } catch (Exception e) {
                        System.out.println("Invalid id.");
                    }
                    break;

                case 4: tm.showAll();       break;
                case 5: tm.showPending();   break;
                case 6: tm.showCompleted(); break;

                case 0:
                    System.out.println("Bye 👋");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}