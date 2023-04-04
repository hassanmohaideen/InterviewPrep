package dataStructures;

import java.util.HashMap;
import java.util.Map;

public class TrieNode<T> {

    T data;

    Map<T, TrieNode<T>> children;

    public TrieNode (T data) {
        this.data = data;
        this.children = new HashMap<>();
    }


    public TrieNode(T data, Map<T, TrieNode<T>> children) {
        this.data = data;
        this.children = children;
    }
}
