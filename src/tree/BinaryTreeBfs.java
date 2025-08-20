package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBfs {

    static class Node {
        int data;
        Node left, right;
        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    Node root;

    public BinaryTreeBfs() {
        root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.data)
            root.left = insertRec(root.left, value);
        else if (value > root.data)
            root.right = insertRec(root.right, value);
        return root;
    }

    public void bfs() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);
        }
        System.out.println();
    }

    // Print tree rotated by 90 degrees (root left, right child above)
    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(Node node, int level) {
        if (node == null)
            return;

        printTree(node.right, level + 1); // print right subtree first (on top)

        // Print current node with indentation
        for (int i = 0; i < level; i++)
            System.out.print("    "); // 4 spaces per level
        System.out.println(node.data);

        printTree(node.left, level + 1); // print left subtree below
    }

    public static void main(String[] args) {
        BinaryTreeBfs tree = new BinaryTreeBfs();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.print("BFS traversal: ");
        tree.bfs();

        System.out.println("\nTree structure:");
        tree.printTree();
    }
}
