package arrays;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 5));
        System.out.println(binarySearchRecursion(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 5));
    }

    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // key thing is to add low here

            if (array[mid] == key) {
                return mid;
            }
            if (key > array[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursion(int[] array, int key) {
        return search(array, 0, array.length - 1, key);
    }

    private static int search(int[] array, int low, int high, int key) {
        if (high >= low) { // not found case
            int mid = low + (high - low) / 2;
            if (array[mid] == key) {
                return mid;
            }

            if (key > array[mid]) {
                return search(array, mid + 1, high, key);
            } else {
                return search(array, low, mid - 1, key);
            }
        }
        return -1;
    }

}
