import dataStructures.LinkedList;
import dataStructures.LinkedListNode;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedListHead = new LinkedList<>(0);
        linkedListHead.appendDataToTail(10);
        linkedListHead.appendLinkedListNodeToTail(new LinkedListNode<>(11));
        linkedListHead.deleteLinkedListNodeFromData(10);

        linkedListHead.appendLinkedListNodeToTail(new LinkedListNode<>(12));
        linkedListHead.appendLinkedListNodeToTail(new LinkedListNode<>(13));
        linkedListHead.appendLinkedListNodeToTail(new LinkedListNode<>(14));
        linkedListHead.appendLinkedListNodeToTail(new LinkedListNode<>(15));
        linkedListHead.appendLinkedListNodeToTail(new LinkedListNode<>(16));
        linkedListHead.appendLinkedListNodeToTail(new LinkedListNode<>(17));
        linkedListHead.appendLinkedListNodeToTail(new LinkedListNode<>(18));
        linkedListHead.appendLinkedListNodeToTail(new LinkedListNode<>(19));
        linkedListHead.appendLinkedListNodeToTail(new LinkedListNode<>(20));
        linkedListHead.appendLinkedListNodeToTail(new LinkedListNode<>(21));

        System.out.println(linkedListHead);

        linkedListHead.weaveLinkedListNodes();
        System.out.println(linkedListHead);
    }
}