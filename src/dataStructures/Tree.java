package dataStructures;

public class Tree<T> {
    TreeNode<T> root;

    public Tree (T data) {
        root = new TreeNode<>(data);
    }
}
