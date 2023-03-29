package dataStructures;

public class LinkedListNode {

    LinkedListNode next = null;
    int data;

    public LinkedListNode(int d) {
        data = d;
    }

    public LinkedListNode(int d, LinkedListNode n) {
        data = d;
        next = n;
    }

    public void appendDataToTail(int d) {
        getTail(this).next = new LinkedListNode(d);
    }

    public void appendLinkedListNodeToTail(LinkedListNode n) {
        getTail(this).next = n;
    }

    public LinkedListNode getTail(LinkedListNode curr) {
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr;
    }

    public void deleteLinkedListNodeFromData(int d) {
        LinkedListNode curr = this;
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

    public void weaveLinkedListNodes() {
        LinkedListNode fastRunner = this;
        LinkedListNode slowRunner = this;

        while(fastRunner != null && fastRunner.next != null) {
            fastRunner = fastRunner.next.next;
            slowRunner = slowRunner.next;
        }
        System.out.println(slowRunner.data);

        LinkedListNode weaveHead = this;
        LinkedListNode weaveHeadNext = this.next;
        LinkedListNode middleHead = slowRunner;
        LinkedListNode middleHeadNext = slowRunner.next;

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
        LinkedListNode curr = this;
        while (curr.next != null) {
            curr = curr.next;
            s.append(curr.data);
            s.append(" -> ");
        }
        s.append("null");
        return s.toString();
    }

}


