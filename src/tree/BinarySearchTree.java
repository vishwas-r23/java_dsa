package tree;

import java.util.Scanner;

public class BinarySearchTree {

    // Node class representing each node in BST
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Insert a key into BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        // If key is duplicate, do nothing
        return root;
    }

    // Inorder traversal
    void inorder() {
        inorderRec(root);
        System.out.println();
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Preorder traversal
    void preorder() {
        preorderRec(root);
        System.out.println();
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Postorder traversal
    void postorder() {
        postorderRec(root);
        System.out.println();
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    // Search a key in BST
    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        if (key < root.key)
            return searchRec(root.left, key);
        return searchRec(root.right, key);
    }

    // Find minimum key value node
    Node minValueNode(Node root) {
        Node current = root;
        while (current.left != null)
            current = current.left;
        return current;
    }

    // Delete a key from BST
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null)
            return root;
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            // node with two children: get inorder successor
            root.key = minValueNode(root.right).key;
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    // Find maximum key value node
    Node maxValueNode(Node root) {
        Node current = root;
        while (current.right != null)
            current = current.right;
        return current;
    }

    // Get height of the BST
    int height() {
        return heightRec(root);
    }

    int heightRec(Node node) {
        if (node == null)
            return 0;
        int leftHeight = heightRec(node.left);
        int rightHeight = heightRec(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Count total nodes
    int countNodes() {
        return countNodesRec(root);
    }

    int countNodesRec(Node node) {
        if (node == null)
            return 0;
        return 1 + countNodesRec(node.left) + countNodesRec(node.right);
    }

    // Count leaf nodes
    int countLeaves() {
        return countLeavesRec(root);
    }

    int countLeavesRec(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        return countLeavesRec(node.left) + countLeavesRec(node.right);
    }

    // Main method with menu-driven interface
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        int choice, key;

        do {
            System.out.println("\n--- Binary Search Tree Operations Menu ---");
            System.out.println("1. Insert key");
            System.out.println("2. Delete key");
            System.out.println("3. Search key");
            System.out.println("4. Inorder traversal");
            System.out.println("5. Preorder traversal");
            System.out.println("6. Postorder traversal");
            System.out.println("7. Get minimum key");
            System.out.println("8. Get maximum key");
            System.out.println("9. Get height of tree");
            System.out.println("10. Count total nodes");
            System.out.println("11. Count leaf nodes");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key to insert: ");
                    key = sc.nextInt();
                    bst.insert(key);
                    System.out.println(key + " inserted.");
                    break;
                case 2:
                    System.out.print("Enter key to delete: ");
                    key = sc.nextInt();
                    if (bst.search(key)) {
                        bst.deleteKey(key);
                        System.out.println(key + " deleted.");
                    } else {
                        System.out.println("Key not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter key to search: ");
                    key = sc.nextInt();
                    boolean found = bst.search(key);
                    if (found)
                        System.out.println("Key found.");
                    else
                        System.out.println("Key not found.");
                    break;
                case 4:
                    System.out.print("Inorder traversal: ");
                    bst.inorder();
                    break;
                case 5:
                    System.out.print("Preorder traversal: ");
                    bst.preorder();
                    break;
                case 6:
                    System.out.print("Postorder traversal: ");
                    bst.postorder();
                    break;
                case 7:
                    if (bst.root != null) {
                        System.out.println("Minimum key: " + bst.minValueNode(bst.root).key);
                    } else {
                        System.out.println("Tree is empty.");
                    }
                    break;
                case 8:
                    if (bst.root != null) {
                        System.out.println("Maximum key: " + bst.maxValueNode(bst.root).key);
                    } else {
                        System.out.println("Tree is empty.");
                    }
                    break;
                case 9:
                    System.out.println("Height of tree: " + bst.height());
                    break;
                case 10:
                    System.out.println("Total nodes: " + bst.countNodes());
                    break;
                case 11:
                    System.out.println("Leaf nodes count: " + bst.countLeaves());
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}

