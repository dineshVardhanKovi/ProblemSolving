package arrays;

/*
Given an array of integers arr[], the task is to move all the zeros to the end of the array while maintaining the relative order of all non-zero elements.

Examples:

Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]
Output: arr[] = [1, 2, 4, 3, 5, 0, 0, 0]
Explanation: There are three 0s that are moved to the end.


Input: arr[] = [10, 20, 30]
Output: arr[] = [10, 20, 30]
Explanation: No change in array as there are no 0s.

Input: arr[] = [0, 0]
Output: arr[] = [0, 0]
Explanation: No change in array as there are all 0s.
 */


import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        moveZerosToEndTwoTraversal(new int[]{1, 2, 0, 3, 0, 5});
        moveZerosToEndOneTraversal(new int[]{1, 2, 0, 3, 0, 5});
    }

    public static void moveZerosToEndTwoTraversal(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                array[count] = array[i];
                count++;
            }
        }

        while (count < array.length) {
            array[count] = 0;
            count++;
        }

        System.out.println(Arrays.toString(array));
    }

    /*
        single traversal approach is to maintain count pointer and
        swap current element with element at count index only if element is non zero
        this ensures that we swap a non zero element in place of zero element
     */
    public static void moveZerosToEndOneTraversal(int[] array) {

        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                int temp = array[i];
                array[i] = array[count];
                array[count] = temp;
                count++;
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
