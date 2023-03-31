package dataStructures;

public class Queue<T> {

    QueueNode<T> head;

    public Queue(T data) {
        head = new QueueNode<>(data);
    }

    public void addData(T data) {
        if (head == null) {
            QueueNode<T> node = new QueueNode<>(data);
            head = node;
        } else {
            QueueNode<T> tail = getTail(head);
            tail.next = new QueueNode<>(data);
        }
    }

    public void addQueueNode(QueueNode<T> node) {
        if (head == null) {
            head = node;
        } else {
            QueueNode<T> tail = getTail(head);
            tail.next = node;
        }
    }

    public QueueNode<T> remove() {
        QueueNode<T> nodeToBeReturned = head;
        head = head.next;
        return nodeToBeReturned;
    }

    public QueueNode<T> peek() {
        return head;
    }

    public boolean isPeek() {
        return head == null;
    }

    public QueueNode<T> getTail(QueueNode<T> curr) {
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr;
    }
}
