package arrays;

/*

Input: arr[] = {1, 2, 3, 4, 5, 6}, d = 2
Output: {5, 6, 1, 2, 3, 4}

*/

import java.util.Arrays;

/*
    1. Understand the Problem (1-2 min)
	• Read the problem statement carefully to avoid misinterpretation.
	• Identify:
		○ Input format (size, range, constraints) : array, no of positions
		○ Output format (exact requirement)
		○ Constraints & edge cases
		○ Special properties (sorted input, unique elements, etc.)
	• Ask: What is the problem actually asking for?

📌 2. Identify the Brute Force Solution (2-5 min)
	• What is the most straightforward way to solve the problem? :
	    shift the elements for d times
	    outer loop run d no of times
	    inner loop will shift the elements
	• Write the simplest solution first, even if it's inefficient.
	• Calculate its time complexity to check feasibility. : O(n*d)
	• If it’s too slow, go to Step 3.

📌 3. Analyze Constraints & Optimize (5-10 min)
	• Look at constraints to determine the required efficiency.
	• Pick the right algorithmic approach:
	    1. We can use reversal approach
	        reverse the entire array

	        reverse first d elements

	        reverse remaining elements

	        O(n)
        2. Use cycle replacement
            take each element and move it to its final position

            the element previously present at this position will be moved to its respective final position

            this continues until all the elements are moved

	• Eliminate unnecessary computations.

*/
public class RotateArray {
    public static void main(String[] args) {
        rotateArray(new int[]{1, 2, 3, 4, 5, 6}, 8);
        rotateArrayUsingReversal(new int[]{1, 2, 3, 4, 5, 6}, 2);
        rotateArrayUsingCycleReplacement(new int[]{1, 2, 3, 4, 5, 6}, 2);
    }

    public static void rotateArray(int[] array, int d) {
        d = d % array.length;

        for (int i = 0; i < d; i++) {
            int last = array[array.length - 1];
            for (int j = array.length - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }
            array[0] = last;
        }

        System.out.println(Arrays.toString(array));
    }

    public static void rotateArrayUsingReversal(int[] array, int d) {
        d = d % array.length;
        reverse(array, 0, array.length - 1);
        reverse(array, 0, d - 1);
        reverse(array, d, array.length - 1);

        System.out.println(Arrays.toString(array));

    }

    public static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }

    }

    public static void rotateArrayUsingCycleReplacement(int[] array, int d) {
        d = d % array.length;
        int count = 0;
        for (int i = 0; count < array.length; i++) {
            int currentIndex = i;
            int prev = array[i];

            do {
                int nextIndex = (currentIndex + d) % array.length; // find the index to which the current element should be moved
                int temp = array[nextIndex]; // swap
                array[nextIndex] = prev;
                prev = temp; // store the  misplaced value
                currentIndex = nextIndex;  // move to the next index where the misplaced value should be placed
                count++; // keep track how many elements are visited
            } while (i != currentIndex);
        }
        System.out.println(Arrays.toString(array));

    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
