package arrays;

import java.util.Arrays;


public class QuickSort {

    public static void main(String[] args) {
        quickSortHoares(new int[]{10, 80, 30, 90, 40});
        quickSortLumoto(new int[]{10, 80, 30, 90, 40});
    }

    private static void quickSortHoares(int[] array) {
        quickSortHoaresHelper(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSortHoaresHelper(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionHoares(array, low, high);
            quickSortHoaresHelper(array, low, pivotIndex);
            quickSortHoaresHelper(array, pivotIndex + 1, high);
        }
    }


    private static int partitionHoares(int[] array, int low, int high) {

        // Choose pivot or pivot index
        int pivot = array[low];

        // start the loop from low -1 and high + 1 to ensure that the first and last elements are also checked for conditions
        int i = low - 1;
        int j = high + 1;
        while (true) {

            // move the index i until there is an element greater than pivot
            do {
                i++;
            } while (array[i] < pivot);

            // move the index j until there is an element less than pivot
            do {
                j--;
            } while (array[j] > pivot);

            // if both pointers crossed each other, it means no swaps are needed and pivot is already in place
            if (i >= j) {
                return j;
            }

            // swap
            swap(array, i, j);
        }

    }

    public static void quickSortLumoto(int[] array) {
        quickSortHoaresHelper(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }


    private static void quickSortHelperLumoto(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionLomuto(array, low, high);
            partitionLomuto(array, low, pivotIndex - 1); // we exclude pivot index as pivot is already in final position unlike Hoares partition
            partitionLomuto(array, pivotIndex + 1, high);
        }
    }


    private static int partitionLomuto(int[] array, int low, int high) {
        int pivot = array[low];

        int i = low;

        // ignore the first element which is pivot as we swap it at the end and place it in its final position
        for (int j = i + 1; j < array.length; j++) {
            if (array[j] < pivot) {
                // when ever there is a smaller element found move this element to end of sorted array. so increase i and swap
                i++;
                swap(array, i, j);
            }
        }

        // move the pivot to its final position
        swap(array, low, i);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
