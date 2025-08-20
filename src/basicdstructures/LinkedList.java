package basicdstructures;
import java.util.Scanner;
public class LinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void addAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void addAtPosition(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtHead(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void removeHead() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
    }

    public void removeTail() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void removeAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (position == 1) {
            removeHead();
            return;
        }
        Node temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Position out of range.");
            return;
        }
        temp.next = temp.next.next;
    }
    
    // Remove first node with the given value
    public void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.data == value) {
            head = head.next;
            System.out.println("Node with value " + value + " deleted from head.");
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Value not found in the list.");
            return;
        }
        temp.next = temp.next.next;
        System.out.println("Node with value " + value + " deleted.");
    }


    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int choice, data, position;

        while (true) {
            System.out.println("\n--- Singly Linked List Menu ---");
            System.out.println("1. Add at Head");
            System.out.println("2. Add at Tail");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove Head");
            System.out.println("5. Remove Tail");
            System.out.println("6. Remove at Position");
            System.out.println("7. Display List");
            System.out.println("8. Delete by Value");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value to insert: ");
                    data = sc.nextInt();
                    list.addAtHead(data);
                }
                case 2 -> {
                    System.out.print("Enter value to insert: ");
                    data = sc.nextInt();
                    list.addAtTail(data);
                }
                case 3 -> {
                    System.out.print("Enter value to insert: ");
                    data = sc.nextInt();
                    System.out.print("Enter position: ");
                    position = sc.nextInt();
                    list.addAtPosition(data, position);
                }
                case 4 -> list.removeHead();
                case 5 -> list.removeTail();
                case 6 -> {
                    System.out.print("Enter position: ");
                    position = sc.nextInt();
                    list.removeAtPosition(position);
                }
                case 7 -> list.display();
                case 8 -> {
                    System.out.print("Enter value to delete: ");
                    int v = sc.nextInt();
                    list.deleteByValue(v);
                }
                case 9 -> {
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
 

