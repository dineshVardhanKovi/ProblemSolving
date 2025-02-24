package arrays;

import java.util.Arrays;

/*
    Problem Solving Framework

    1. Read & Understand the problem
        Input : Array
        Output : Integer(Second largest number)
        Constraints :
            1. Array may contain duplicates,
            2. Size can be less than 2
        Special Properties :

     2. Brute Force :
        Sort the array and find the second highest number considering duplicates
        O(nlogn)
     3. can we do it in O(n) ??
        Do single traversal and maintain firstMax and secondMax variables
        O(n)
     4. Choose the best data structure:
        we just need integers here.
     5. psuedo code
           for int i in array
                firstMax = Math.max(i, firstMax)
                if i < firstMax
                secondMax = Math.max(i , secondMax)
            return secondMax;
 */
public class SecondLargestElement {
    public static void main(String[] args) {
        System.out.println(findSecondLargestUsingSorting(new int[]{12, 35, 1, 10, 34, 1, 35}));
        System.out.println(findSecondLargestUsingTwoPassSearch(new int[]{12, 35, 1, 10, 34, 1, 35}));
        System.out.println(findSecondLargestUsingOnePassSearch(new int[]{12, 35, 1, 10, 34, 1, 35}));
    }

    public static int findSecondLargestUsingSorting(int[] array) {

        if (array.length <= 1) {
            return -1;
        }

        Arrays.sort(array);

        int firstMax = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] != firstMax) {
                return array[i];
            }
        }
        return -1;
    }

    public static int findSecondLargestUsingTwoPassSearch(int[] array) {
        if (array.length <= 1) {
            return -1;
        }

        int firstMax = -1;
        for (int i : array) {
            firstMax = Math.max(firstMax, i);
        }

        int secondMax = -1;

        for (int i : array) {
            if (i != firstMax) {
                secondMax = Math.max(secondMax, i);
            }
        }
        return secondMax;
    }

    public static int findSecondLargestUsingOnePassSearch(int[] array) {
        if (array.length <= 1) {
            return -1;
        }
        int firstMax = -1;
        int secondMax = -1;
        for (int i : array) {
            if (i > firstMax) {
                firstMax = i;
            } else if (i < firstMax && i > secondMax) {
                secondMax = i;
            }
        }
        return secondMax;
    }
}
