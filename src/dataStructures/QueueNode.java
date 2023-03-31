package dataStructures;

public class QueueNode<T> {

    T data;

    QueueNode<T> next;

    public QueueNode (T d) {
        data = d;
        next = null;
    }

    public QueueNode (T d, QueueNode<T> n) {
        data = d;
        next = n;
    }
}
