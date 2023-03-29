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

    public void deleteNodeFromData(int d) {
        Node curr = this;
        if (curr.data == d) {
            return;
        }

        while (curr.next != null) {
            if (curr.next.data == d) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    public void weaveNodes() {
        Node fastRunner = this;
        Node slowRunner = this;

        while(fastRunner != null && fastRunner.next != null) {
            fastRunner = fastRunner.next.next;
            slowRunner = slowRunner.next;
        }
        System.out.println(slowRunner.data);

        Node weaveHead = this;
        Node weaveHeadNext = this.next;
        Node middleHead = slowRunner;
        Node middleHeadNext = slowRunner.next;

        while (middleHead != null) {
            weaveHead.next = middleHead;
            // Make sure to add this to the weave
            if (middleHeadNext == null) {
                middleHead.next = null;
                return;
            }

            middleHead.next = weaveHeadNext;

            weaveHead = weaveHeadNext;
            weaveHeadNext = weaveHeadNext.next;

            middleHead = middleHeadNext;
            middleHeadNext = middleHeadNext.next;
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder(String.valueOf(this.data));
        s.append(" -> ");
        Node curr = this;
        while (curr.next != null) {
            curr = curr.next;
            s.append(curr.data);
            s.append(" -> ");
        }
        s.append("null");
        return s.toString();
    }

}


