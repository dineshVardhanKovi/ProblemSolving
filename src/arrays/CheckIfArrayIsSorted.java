package arrays;

/*
    1. Understand the Problem:
        ○ Input format (size, range, constraints) : array
		○ Output format (exact requirement) : boolean
		○ Constraints & edge cases : can have duplicates and 0 or 1 elements also
        ○ Special properties (sorted input, unique elements, etc.) :
    2. Brute Force :
    	• What is the most straightforward way to solve the problem?
    	     compare consecutive elements till the end of array and break if i-1 is > i
        • Write the simplest solution first, even if it's inefficient.
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


 */
public class CheckIfArrayIsSorted {
    public static void main(String[] args) {
        System.out.println(checkIfSorted(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(checkIfSorted(new int[]{1, 2, 3, 3, 5, 6}));
        System.out.println(checkIfSorted(new int[]{1, 6, 3, 3, 5, 6}));
        System.out.println(checkIfSorted(new int[]{1, 2, 3, 3, 7, 6}));
        System.out.println(checkIfSorted(new int[]{1, 2, 3, 3, 5, 2}));

        System.out.println("#######################################");

        System.out.println(checkIfSortedUsingRecursion(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(checkIfSortedUsingRecursion(new int[]{1, 2, 3, 3, 5, 6}));
        System.out.println(checkIfSortedUsingRecursion(new int[]{1, 6, 3, 3, 5, 6}));
        System.out.println(checkIfSortedUsingRecursion(new int[]{1, 2, 3, 3, 7, 6}));
        System.out.println(checkIfSortedUsingRecursion(new int[]{1, 2, 3, 3, 5, 2}));
    }

    public static boolean checkIfSorted(int[] array) {
        if (array.length <= 1) {
            return true;
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkIfSortedUsingRecursion(int[] array) {
        return checkIfSortedRecursionHelper(array, array.length);
    }

    public static boolean checkIfSortedRecursionHelper(int[] array, int index) {
        if (index == 0 || index == 1) {
            return true;
        }
        return array[index - 1] >= array[index - 2] && checkIfSortedRecursionHelper(array, index - 1);
    }
}
