package arrays;
/*
    Given an array arr[], the task is to generate all the possible subarrays of the given array.

    Examples:

    Input: arr[] = [1, 2, 3]
    Output: [ [1], [1, 2], [2], [1, 2, 3], [2, 3], [3] ]

    Input: arr[] = [1, 2]
    Output: [ [1], [1, 2], [2] ]

 */


/*

    1. Understand the Problem (1-2 min)
	• Read the problem statement carefully to avoid misinterpretation.
	• Identify:
		○ Input format (size, range, constraints) : array
		○ Output format (exact requirement) : void need to print the sub arrays
		○ Constraints & edge cases
		○ Special properties (sorted input, unique elements, etc.)
	• Ask: What is the problem actually asking for?

📌 2. Identify the Brute Force Solution (2-5 min)
	• What is the most straightforward way to solve the problem? :
	Take each element and form the sub arrays till the end of array
	• Write the simplest solution first, even if it's inefficient.
	• Calculate its time complexity to check feasibility. O(n3)
	• If it’s too slow, go to Step 3.

📌 3. Analyze Constraints & Optimize (5-10 min)
	• Look at constraints to determine the required efficiency.
	• Pick the right algorithmic approach: Recursion can do this in O(n2)

We can also use recursion and two pointers start and end
for each start we iterate till the end of end pointer


break condition : if end == arr.length

if(start< end)
    for(int i = start, i<end;i++){
        print array[i]

    print array[end] // last element

    recursion(array, start+1, end)

 */
public class GenerateSubArrays {
    public static void main(String[] args) {
        printAllSubArrays(new int[]{1, 2, 3, 4});
        System.out.println("####################");
        printAllSubArraysUsingRecursion(new int[]{1, 2, 3, 4});
    }

    public static void printAllSubArrays(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(array[k] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void printAllSubArraysUsingRecursion(int[] array) {
        printSubArrays(array, 0, 0);
    }


    public static void printSubArrays(int[] array, int start, int end) {
        if (start == array.length) {
            return;
        }

        if (end == array.length) {
            printSubArrays(array, start + 1, start + 1);
            return;
        }

        for (int i = start; i <= end; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        printSubArrays(array, start, end + 1);
    }
}
