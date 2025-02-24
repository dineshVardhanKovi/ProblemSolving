package arrays;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        insertionSort(new int[]{4, 3, 6, 1, 5, 2});
        insertionSort(new int[]{4, 3, 6, 1, 5, 5});
    }

    public static void insertionSort(int[] array) {


        if (array.length == 0) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int curr = array[i];

            while (j >= 0 && array[j] > curr) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = curr;
        }

        System.out.println(Arrays.toString(array));
    }
}
