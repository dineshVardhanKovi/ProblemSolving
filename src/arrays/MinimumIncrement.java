package arrays;

/*
You are given an array of n-elements, you have to find the number of operations needed to make all elements of array equal. Where a single operation can increment an element by k. If it is not possible to make all elements equal print -1.

Example :

Input : arr[] = {4, 7, 19, 16},  k = 3
Output : 10

Input : arr[] = {4, 4, 4, 4}, k = 3
Output : 0

Input : arr[] = {4, 2, 6, 8}, k = 3
Output : -1


Try it on GfG Practice

 */
public class MinimumIncrement {
    public static void main(String[] args) {
        System.out.println(findMinIncrement(new int[]{4, 7, 19, 16}, 3));
        System.out.println(findMinIncrement(new int[]{4, 4, 4, 4}, 3));
        System.out.println(findMinIncrement(new int[]{4, 3, 2, 1}, 3));
    }

    public static int findMinIncrement(int[] array, int k) {

        int max = Integer.MIN_VALUE;
        int res = 0;
        for (int j : array) {
            max = Math.max(max, j);
        }

        for (int j : array) {
            if ((max - j) % k != 0) {
                return -1;
            } else {
                res += (max - j) / k;
            }
        }
        return res;
    }
}
