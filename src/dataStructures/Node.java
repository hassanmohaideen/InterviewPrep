package dataStructures;

public class Node {

    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    public Node(int d, Node n) {
        data = d;
        next = n;
    }

    public void appendDataToTail(int d) {
        getTail(this).next = new Node(d);
    }

    public void appendNodeToTail(Node n) {
        getTail(this).next = n;
    }

    public Node getTail(Node curr) {
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr;
    }

}


