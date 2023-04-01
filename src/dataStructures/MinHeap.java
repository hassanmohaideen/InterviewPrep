package dataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeap {

    public List<Integer> items;

    private int currSize;

    public MinHeap() {
        this.items = new ArrayList<>();
        this.currSize = 0;
    }

    public MinHeap(List<Integer> items) {
        this.items = items;
        this.currSize = items.size();
    }

    public void insert(int item) {
        this.items.add(item);
        int addedIndex = currSize;
        currSize++;
        int parentNodeIndex = getParentNodeIndex(addedIndex);
        while (parentNodeIndex >= 0 && this.items.get(parentNodeIndex) > this.items.get(addedIndex)) {
            swap(parentNodeIndex, addedIndex);
            addedIndex = parentNodeIndex;
            parentNodeIndex = getParentNodeIndex(addedIndex);
        }
    }

    public int getMin() {
        return items.get(0);
    }

    public int extractMin() {
        int itemToReturn =  items.get(0);
        currSize--;
        items.set(0, items.get(currSize));
        items.remove(currSize);
        percolateDown(0);
        return itemToReturn;
    }

    public void percolateDown(int indexOfValueToPercolateDown) {
        if (isLeaf(indexOfValueToPercolateDown)) return;

        int smallerValueChildIndex = hasOnlyOneChild(indexOfValueToPercolateDown)
            ? getLeftNodeIndex(indexOfValueToPercolateDown)
            : getSmallerValueChildIndex(indexOfValueToPercolateDown);

        while (items.get(indexOfValueToPercolateDown) > items.get(smallerValueChildIndex)) {
            swap(indexOfValueToPercolateDown, smallerValueChildIndex);
            percolateDown(smallerValueChildIndex);
        }
    }

    private int getSmallerValueChildIndex(int index) {
        return items.get(getLeftNodeIndex(index)) < items.get(getRightNodeIndex(index))
            ? getLeftNodeIndex(index)
            : getRightNodeIndex(index);
    }

    private void swap(int firstIndex, int secondIndex) {
        int temp = items.get(firstIndex);
        items.set(firstIndex, items.get(secondIndex));
        items.set(secondIndex, temp);
    }

    private boolean isLeaf(int index) {
        int leftIndex = getLeftNodeIndex(index);
        int rightIndex = getRightNodeIndex(index);
        return leftIndex >= currSize && rightIndex >= currSize;
    }

    private boolean hasOnlyOneChild(int index) {
        int leftIndex = getLeftNodeIndex(index);
        int rightIndex = getRightNodeIndex(index);
        return leftIndex < currSize && rightIndex >= currSize;
    }

    private int getLeftNodeIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int getRightNodeIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    public int getParentNodeIndex(int childIndex) {
        return (int) Math.floor(((childIndex - 1)/2.0));
    }

    public void dump() {
        int level = 0;
        int numberOfItemsToTakeForLevel = (int) Math.pow(2, level);
        int height = log2(this.items.size()) + 1;
        for (int i = 0; i < this.items.size(); i++) {
            int numberToDisplay = this.items.get(i);
            int spaces = (height - level) * 2;

            System.out.print(stringOfSize(spaces, ' '));
            System.out.print(numberToDisplay);
            numberOfItemsToTakeForLevel--;
            if (numberOfItemsToTakeForLevel == 0) {
                level++;
                numberOfItemsToTakeForLevel = (int) Math.pow(2, level);
                System.out.println();
            }
        }
    }

    public int log2(int x) {
        if (x == 0) return 0;
        return (int)Math.floor(Math.log(x) / Math.log(2));
    }

    private String stringOfSize(int size, char ch) {
        char[] a = new char[size];
        Arrays.fill(a, ch);
        return new String(a);
    }
}
