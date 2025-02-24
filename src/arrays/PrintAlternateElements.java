package arrays;

public class PrintAlternateElements {
    public static void main(String[] args) {
        PrintAlternateElements.printAlternateElements(new int[]{1, 2, 3, 4, 5});
    }

    public static void printAlternateElements(int[] array) {
        for (int i = 0; i < array.length; i = i + 2) {
            System.out.println(array[i]);
        }
    }

}
