package dataStructures;

public class StackNode<T> {

    T data;

    StackNode<T> next;

    StackNode(T d) {
        data = d;
    }

    StackNode(T d, StackNode<T> n) {
        data = d;
        next = n;
    }

}
