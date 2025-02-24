package arrays;
/*

    Given an array arr[], the task is to reverse the array. Reversing an array means rearranging the elements such that the first element becomes the last, the second element becomes second last and so on.

    Examples:

    Input: arr[] = {1, 4, 3, 2, 6, 5}
    Output: {5, 6, 2, 3, 4, 1}
    Explanation: The first element 1 moves to last position, the second element 4 moves to second-last and so on.


    Input: arr[] = {4, 5, 1, 2}
    Output: {2, 1, 5, 4}
    Explanation: The first element 4 moves to last position, the second element 5 moves to second last and so on.

 */


import java.util.Arrays;

/*

📌 1. Understand the Problem (1-2 min)
	• Read the problem statement carefully to avoid misinterpretation.
	• Identify:
		○ Input format (size, range, constraints) : array
		○ Output format (exact requirement) : void need to reverse an array
		○ Constraints & edge cases
		○ Special properties (sorted input, unique elements, etc.)
	• Ask: What is the problem actually asking for?

📌 2. Identify the Brute Force Solution (2-5 min)
	• What is the most straightforward way to solve the problem? :
	      create a new array and populate it by iterating the given array in reverse
	      then again update the given array
	• Write the simplest solution first, even if it's inefficient.
	• Calculate its time complexity to check feasibility. O(n) , O(n)
	• If it’s too slow, go to Step 3. yes can do better

📌 3. Analyze Constraints & Optimize (5-10 min)
	• Look at constraints to determine the required efficiency.
	• Pick the right algorithmic approach:
	    1. Single iteration but swapping the elements i , n-i until middle point : O(n), O(1) but loops run only till half
	    2. Recursion : O(n), O(n)
	    3. Inbuilt methods


 */
public class ReverseArray {
    public static void main(String[] args) {
        reverseArray(new int[]{1, 2, 3, 4, 5});
        reverseArray(new int[]{1, 2, 3, 4, 5, 6});

        System.out.println("####################################");

        reverseArrayUsingRecursion(new int[]{1, 2, 3, 4, 5});
        reverseArrayUsingRecursion(new int[]{1, 2, 3, 4, 5, 6});
    }

    public static void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            if (i != array.length - i - 1) {
                int temp = array[i];
                array[i] = array[array.length - i - 1];
                array[array.length - i - 1] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void reverseArrayUsingRecursion(int[] array) {
        reverse(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void reverse(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;

        reverse(array, left + 1, right - 1);
    }
}
