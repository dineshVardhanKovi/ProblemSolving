package arrays;

import java.util.Arrays;

public class LargestElement {
    public static void main(String[] args) {
        System.out.println(LargestElement.findLargestElement(new int[]{19, 32, 4, 53, 1, 9}));
        System.out.println(LargestElement.findLargestElementUsingRecursion(new int[]{19, 32, 4, 53, 1, 9}));
        System.out.println(LargestElement.findLargestElementUsingLibraryMethods(new int[]{19, 32, 4, 53, 1, 9}));
    }

    // O(n), O(1)
    public static int findLargestElement(int[] array) {
        if (array.length > 0) {
            int max = array[0];
            for (int i = 1; i < array.length; i++) {
                max = Math.max(array[i], max);
            }
            return max;
        }
        return 0;
    }

    // O(n), O(n)
    public static int findLargestElementUsingRecursion(int[] array) {
        return findMax(array, 0);
    }

    private static int findMax(int[] array, int i) {
        if (i == array.length - 1) {
            return array[i];
        }
        int max = findMax(array, i + 1);

        return Math.max(max, array[i]);
    }

    public static int findLargestElementUsingLibraryMethods(int[] array) {
        Arrays.sort(array);
        return array[array.length - 1];
    }
}
