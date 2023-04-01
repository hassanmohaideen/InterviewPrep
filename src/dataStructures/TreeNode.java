package dataStructures;

public class TreeNode<T> {

    T data;

    TreeNode<T> [] children;

    public TreeNode (T data) {
        this.data = data;
    }

    public TreeNode(T data, TreeNode<T>[] children) {
        this.data = data;
        this.children = children;
    }
}
