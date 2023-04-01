import dataStructures.LinkedList;
import dataStructures.LinkedListNode;
import dataStructures.MinHeap;

public class Main {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(9);
        minHeap.insert(8);
        minHeap.insert(7);
        minHeap.insert(6);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(0);
//        System.out.println(minHeap.extractMin());
//        System.out.println(minHeap.items);
        minHeap.dump();
    }
}