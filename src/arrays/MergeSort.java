package arrays;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        mergeSort(new int[]{4, 3, 6, 1, 5, 2});
        mergeSort(new int[]{4, 3, 6, 1, 5, 5});
    }

    public static void mergeSort(int[] array) {
        System.out.println(Arrays.toString(mergeSort(array, 0, array.length - 1)));
    }

    private static int[] mergeSort(int[] array, int low, int high) {
        // base condition
        if (high == low) {
            return new int[]{array[high]};
        }
        int mid = low + (high - low) / 2;
        int[] left = mergeSort(array, low, mid);
        int[] right = mergeSort(array, mid + 1, high);
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] mergedArray = new int[left.length + right.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                mergedArray[k++] = left[i++];
            } else {
                mergedArray[k++] = right[j++];
            }
        }

        while (i < left.length) {
            mergedArray[k++] = left[i++];
        }

        while (j < right.length) {
            mergedArray[k++] = right[j++];
        }
        return mergedArray;
    }
}
