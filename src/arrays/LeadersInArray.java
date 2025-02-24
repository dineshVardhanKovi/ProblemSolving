package arrays;

/*
    Problem Statement:
    Given an array arr[] of size n, the task is to find all the Leaders in the array. An element is a Leader if it is greater than or equal to all the elements to its right side.

    Note: The rightmost element is always a leader.

    Examples:

    Input: arr[] = [16, 17, 4, 3, 5, 2]
    Output: [17 5 2]
    Explanation: 17 is greater than all the elements to its right i.e., [4, 3, 5, 2], therefore 17 is a leader. 5 is greater than all the elements to its right i.e., [2], therefore 5 is a leader. 2 has no element to its right, therefore 2 is a leader.


    Input: arr[] = [1, 2, 3, 4, 5, 2]
    Output: [5 2]
    Explanation: 5 is greater than all the elements to its right i.e., [2], therefore 5 is a leader. 2 has no element to its right, therefore 2 is a leader.
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    1. Understand the Problem:
        ○ Input format (size, range, constraints) : array
		○ Output format (exact requirement) : array
		○ Constraints & edge cases : can have duplicates
        ○ Special properties (sorted input, unique elements, etc.) :  right most element is always a leader
    2. Brute Force :
    	• What is the most straightforward way to solve the problem?
    	     Take each element and check whether remaining elements are less than this number till the end of array
        • Write the simplest solution first, even if it's inefficient.
        • Calculate its time complexity to check feasibility. : O(n2)
        • If it’s too slow, go to Step 3.
    3. Analyze Constraints & Optimize (5-10 min)
	• Look at constraints to determine the required efficiency.
	• Pick the right algorithmic approach:
	   Start from the end and check if current element is the max till now.
	   If true it is a leader. O(n)
	• Eliminate unnecessary computations.

 */
public class LeadersInArray {
    public static void main(String[] args) {
        System.out.println(LeadersInArray.findLeaders(new int[]{1, 2, 3, 4, 5, 2}));
        System.out.println(LeadersInArray.findLeaders(new int[]{1, 2, 5, 4, 5, 2}));
        System.out.println(LeadersInArray.findLeaders(new int[]{16, 17, 4, 3, 5, 2}));
        System.out.println("#################################");
        System.out.println(LeadersInArray.findLeadersUsingBruteForce(new int[]{1, 2, 4, 5, 2}));
        System.out.println(LeadersInArray.findLeadersUsingBruteForce(new int[]{1, 2, 5, 4, 5, 2}));
        System.out.println(LeadersInArray.findLeadersUsingBruteForce(new int[]{16, 17, 4, 3, 5, 2}));
    }

    public static List<Integer> findLeaders(int[] array) {

        List<Integer> leaders = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int j = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (max != array[i]) { // to check for duplicates
                max = Math.max(array[i], max);
                if (array[i] == max) {
                    leaders.add(array[i]);
                }
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }

    public static List<Integer> findLeadersUsingBruteForce(int[] array) {
        List<Integer> leaders = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int j;
            for (j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    break;
                }
            }
            if (j == array.length) {
                leaders.add(array[i]);
            }
        }
        return leaders;
    }
}
