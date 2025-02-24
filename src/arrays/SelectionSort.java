package arrays;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        selectionSort(new int[]{4, 3, 6, 1, 5, 2});
        selectionSort(new int[]{4, 3, 6, 1, 5, 5});
    }

    public static void selectionSort(int[] array) {

        if (array.length == 0) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = temp;
        }

        System.out.println(Arrays.toString(array));
    }
}
