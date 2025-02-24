package arrays;

/*
    Given a sorted array arr[] of size n, the goal is to rearrange the array so that all distinct elements appear at the
     beginning in sorted order. Additionally, return the length of this distinct sorted subarray.

    Note: The elements after the distinct ones can be in any order and hold any value, as they don’t affect the result.


    Examples:

            Input: arr[] = [2, 2, 2, 2, 2]
            Output: [2]
            Explanation: All the elements are 2, So only keep one instance of 2.


            Input: arr[] = [1, 2, 2, 3, 4, 4, 4, 5, 5]
            Output: [1, 2, 3, 4, 5]

            Input: arr[] = [1, 2, 3]
            Output: [1, 2, 3]
            Explanation : No change as all elements are distinct.
 */


/*
    1. Understand the Problem (1-2 min)
	• Read the problem statement carefully to avoid misinterpretation.
	• Identify:
		○ Input format (size, range, constraints) : array
		○ Output format (exact requirement)
		○ Constraints & edge cases
		○ Special properties (sorted input, unique elements, etc.)
	• Ask: What is the problem actually asking for?

📌 2. Identify the Brute Force Solution (2-5 min)
	• What is the most straightforward way to solve the problem? : use a hashset to track duplicates and replace the duplicated item with next element
	• Write the simplest solution first, even if it's inefficient.
	• Calculate its time complexity to check feasibility.
	• If it’s too slow, go to Step 3.

📌 3. Analyze Constraints & Optimize (5-10 min)
	• Look at constraints to determine the required efficiency.
	• Pick the right algorithmic approach:
		○ Sorting → O(n log n)
		○ Two pointers / Sliding Window → O(n)
		○ Binary Search → O(log n)
		○ Dynamic Programming (DP) → O(n²), O(n log n), or O(n)
		○ Graph algorithms → O(V + E), Dijkstra (O(E log V))
	• Eliminate unnecessary computations.

📌 4. Choose the Best Data Structure : HashSet
	• Use the right data structures for efficiency:
		○ Array → Fast access O(1), but slow inserts/deletes.
		○ HashMap / HashSet → O(1) average lookup.
		○ Stack / Queue → First In First Out (FIFO) / Last In First Out (LIFO).
		○ Heap / Priority Queue → O(log n) insert & extract.
		○ Graph (Adjacency List / Matrix) → Used for pathfinding.

 */

import java.util.HashSet;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println(rearrangeDuplicates(new int[]{2, 2, 2, 2, 2}));
        System.out.println(rearrangeDuplicates(new int[]{1, 2, 2, 3, 4, 4, 4, 5, 5}));
        System.out.println(rearrangeDuplicates(new int[]{1, 2, 3}));
        System.out.println(rearrangeDuplicates(new int[]{}));
        System.out.println(rearrangeDuplicates(new int[]{2}));

        System.out.println("############################################");

        System.out.println(rearrangeDuplicatesUsingHashSet(new int[]{2, 2, 2, 2, 2}));
        System.out.println(rearrangeDuplicatesUsingHashSet(new int[]{1, 2, 2, 3, 4, 4, 4, 5, 5}));
        System.out.println(rearrangeDuplicatesUsingHashSet(new int[]{1, 2, 3}));
        System.out.println(rearrangeDuplicatesUsingHashSet(new int[]{}));
        System.out.println(rearrangeDuplicatesUsingHashSet(new int[]{2}));

    }

    public static int rearrangeDuplicatesUsingHashSet(int[] array) {

        HashSet<Integer> distinctValues = new HashSet<>();
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (!distinctValues.contains(array[i])) {
                distinctValues.add(array[i]);
                array[index++] = array[i];
            }
        }
        return index;
    }

    public static int rearrangeDuplicates(int[] array) {
        if (array.length <= 1) {
            return array.length;
        }
        int index = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                array[index++] = array[i];
            }
        }
        return index;
    }
}
