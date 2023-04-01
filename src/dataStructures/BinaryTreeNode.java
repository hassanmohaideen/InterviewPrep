package dataStructures;

public class BinaryTreeNode<T> {

    T data;

    BinaryTreeNode<T> left;

    BinaryTreeNode<T> right;

    public BinaryTreeNode (T data) {
        this.data = data;
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
