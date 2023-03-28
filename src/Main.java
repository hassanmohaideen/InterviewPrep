import dataStructures.Node;

public class Main {
    public static void main(String[] args) {
        Node linkedListHead = new Node(0);
        linkedListHead.appendDataToTail(10);
        linkedListHead.appendNodeToTail(new Node(11));
        System.out.println(linkedListHead);
    }
}