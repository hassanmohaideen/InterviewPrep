package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {

    T data;

    List<T> children;

    public TreeNode (T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }


    public TreeNode(T data, List<T> children) {
        this.data = data;
        this.children = children;
    }
}
