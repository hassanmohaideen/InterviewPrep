import dataStructures.Node;

public class Main {
    public static void main(String[] args) {
        Node linkedListHead = new Node(0);
        linkedListHead.appendDataToTail(10);
        linkedListHead.appendNodeToTail(new Node(11));
        linkedListHead.deleteNodeFromData(10);

        linkedListHead.appendNodeToTail(new Node(12));
        linkedListHead.appendNodeToTail(new Node(13));
        linkedListHead.appendNodeToTail(new Node(14));
        linkedListHead.appendNodeToTail(new Node(15));
        linkedListHead.appendNodeToTail(new Node(16));
        linkedListHead.appendNodeToTail(new Node(17));
        linkedListHead.appendNodeToTail(new Node(18));
        linkedListHead.appendNodeToTail(new Node(19));
        linkedListHead.appendNodeToTail(new Node(20));
        linkedListHead.appendNodeToTail(new Node(21));

        System.out.println(linkedListHead);

        linkedListHead.weaveNodes();
        System.out.println(linkedListHead);
    }
}