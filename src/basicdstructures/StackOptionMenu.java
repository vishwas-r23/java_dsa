
package basicdstructures;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Stack using Linked List
class StackLinkedList {
    private Node top;

    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; this.next = null; }
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return -1;
        }
        int val = top.data;
        top = top.next;
        return val;
    }

    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return top.data;
    }

    public void display() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack: ");
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

// Stack using a Single Queue (costly pop operation)
class StackQueue {
    private Queue<Integer> q = new LinkedList<>();

    public void push(int val) {
        q.add(val);
    }

    public int pop() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        // Rotate all elements except the last, remove and return the last
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
        return q.remove();
    }

    public int peek() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
        int val = q.peek();
        q.add(q.remove()); // restore original order
        return val;
    }

    public void display() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack (top->bottom): ");
        Object[] arr = q.toArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class StackOptionMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int initialChoice = 0;

        do {
            System.out.println("\nChoose Stack Implementation:");
            System.out.println("1. Using Linked List");
            System.out.println("2. Using Queue");
            System.out.println("3. Exit Program");
            System.out.print("Enter your choice: ");
            initialChoice = sc.nextInt();

            switch (initialChoice) {
                case 1:
                    stackLinkedListMenu();
                    break;
                case 2:
                    stackQueueMenu();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (initialChoice != 3);

        sc.close();
    }

    private static void stackLinkedListMenu() {
        Scanner sc = new Scanner(System.in);
        StackLinkedList stack = new StackLinkedList();
        int choice, val;

        do {
            System.out.println("\n--- Stack (Linked List) Operations ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    val = sc.nextInt();
                    stack.push(val);
                    break;
                case 2:
                    val = stack.pop();
                    if (val != -1) System.out.println("Popped: " + val);
                    break;
                case 3:
                    val = stack.peek();
                    if (val != -1) System.out.println("Top: " + val);
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    private static void stackQueueMenu() {
        Scanner sc = new Scanner(System.in);
        StackQueue stack = new StackQueue();
        int choice, val;

        do {
            System.out.println("\n--- Stack (Queue) Operations ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    val = sc.nextInt();
                    stack.push(val);
                    break;
                case 2:
                    val = stack.pop();
                    if (val != -1) System.out.println("Popped: " + val);
                    break;
                case 3:
                    val = stack.peek();
                    if (val != -1) System.out.println("Top: " + val);
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }
}
