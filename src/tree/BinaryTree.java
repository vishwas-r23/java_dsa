package tree;
// Node class for Binary Tree
class Nodes {
    int data;
    Nodes left, right;

    public Nodes(int item) {
        data = item;
        left = right = null;
    }
}

// Binary Tree class
public class BinaryTree {
    Nodes root;

    public BinaryTree() {
        root = null;
    }

    // Insert method (example: insert in level order)
    public void insert(int data) {
        root = insert(root, data);
    }

    // Recursive insert method (simple BST insertion)
    private Nodes insert(Nodes node, int data) {
        if (node == null) {
            node = new Nodes(data);
            return node;
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        return node;
    }

    // Inorder traversal
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Nodes node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    // Preorder traversal
    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(Nodes node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Postorder traversal
    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(Nodes node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    // Main method to run example
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        /* Example insertion */
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.print("Inorder traversal: ");
        tree.inorder();

        System.out.print("Preorder traversal: ");
        tree.preorder();

        System.out.print("Postorder traversal: ");
        tree.postorder();
    }
}

