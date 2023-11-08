package sorting;

import java.util.Arrays;

public class QuickSort {

    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int partition(int start, int end, int[] arr) {
        int pivot = arr[end];
        int startSwapIndex = start;

        for (int i=start; i<end; i++) {
            if (arr[i] <= pivot) {
                swap(i, startSwapIndex, arr);
                startSwapIndex++;
            }
        }

        // Put the pivot in the right spot
        swap(startSwapIndex, end, arr);
        return startSwapIndex;
    }

    public void quickSort(int start, int end, int[] arr) {
        if (start < end) {
            int partitionIndex = partition(start, end, arr);

            quickSort(start, partitionIndex-1, arr);
            quickSort(partitionIndex+1, end, arr);
        }
    }

    public void callQuickSort() {
        int[] arr = new int[] {4, 7, 2, 4, 9, 8};
        quickSort(0, arr.length-1, arr);
        System.out.println(Arrays.toString(arr));
    }
}
