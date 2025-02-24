package arrays;

public class LinearSearch {
    public static void main(String[] args) {
        System.out.println(LinearSearch.search(new int[]{1, 2, 3, 4, 5, 6, 7}, 5));
        System.out.println(LinearSearch.search(new int[]{1, 2, 3, 4, 5, 6, 7}, 15));
    }

    public static int search(int[] array, int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                return i;
            }
        }
        return -1;
    }
}
