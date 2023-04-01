package dataStructures;

public class BinaryTree<T> {

    BinaryTreeNode<T> root;

    public BinaryTree(T data) {
        root = new BinaryTreeNode<>(data);
    }

    public void printInOrderTraversal(BinaryTreeNode<T> root) {
        if (root != null) {
            printInOrderTraversal(root.left);
            System.out.println(root.data);
            printInOrderTraversal(root.right);
        }
    }

    public void printPostOrderTraversal(BinaryTreeNode<T> root) {
        if (root != null) {
            printInOrderTraversal(root.left);
            printInOrderTraversal(root.right);
            System.out.println(root.data);
        }
    }

    public void prePostOrderTraversal(BinaryTreeNode<T> root) {
        if (root != null) {
            System.out.println(root.data);
            printInOrderTraversal(root.left);
            printInOrderTraversal(root.right);
        }
    }

}
