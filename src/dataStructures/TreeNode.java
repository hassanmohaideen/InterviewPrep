package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {

    T data;

    List<TreeNode<T>> children;

    public TreeNode (T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }


    public TreeNode(T data, List<TreeNode<T>> children) {
        this.data = data;
        this.children = children;
    }

    public void addChild(TreeNode<T> child) {
        children.add(child);
    }

    public T getData() {
        return data;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }
}
