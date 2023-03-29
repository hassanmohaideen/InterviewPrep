package dataStructures;

public class LinkedListNode<T> {

    LinkedListNode<T> next = null;
    T data;

    public LinkedListNode(T d) {
        data = d;
    }

    public LinkedListNode(T d, LinkedListNode<T> n) {
        data = d;
        next = n;
    }

    public String toString() {
        StringBuilder s = new StringBuilder(String.valueOf(this.data));
        s.append(" -> ");
        LinkedListNode<T> curr = this;
        while (curr.next != null) {
            curr = curr.next;
            s.append(curr.data);
            s.append(" -> ");
        }
        s.append("null");
        return s.toString();
    }

}


