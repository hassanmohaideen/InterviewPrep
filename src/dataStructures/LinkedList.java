package dataStructures;

public class LinkedList<T> {

    LinkedListNode<T> head;

    public LinkedList(T data) {
        head = new LinkedListNode<T>(data);
    }

    public LinkedList(LinkedListNode<T> node) {
        head = node;
    }

    public void appendDataToTail(T d) {
        getTail(head).next = new LinkedListNode<T>(d);
    }

    public void appendLinkedListNodeToTail(LinkedListNode<T> n) {
        getTail(head).next = n;
    }

    public LinkedListNode<T> getTail(LinkedListNode<T> curr) {
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr;
    }

    public void weaveLinkedListNodes() {
        LinkedListNode<T> fastRunner = head;
        LinkedListNode<T> slowRunner = head;

        while(fastRunner != null && fastRunner.next != null) {
            fastRunner = fastRunner.next.next;
            slowRunner = slowRunner.next;
        }

        LinkedListNode<T> weaveHead = head;
        LinkedListNode<T> weaveHeadNext = head.next;
        LinkedListNode<T> middleHead = slowRunner;
        LinkedListNode<T> middleHeadNext = slowRunner.next;

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

    public void deleteLinkedListNodeFromData(T d) {
        LinkedListNode<T> curr = head;
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

    public String toString() {
        return head.toString();
    }
}
