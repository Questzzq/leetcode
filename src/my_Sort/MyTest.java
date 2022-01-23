package my_Sort;

public class MyTest {
    public static void main(String[] args) {
        int [] a = {3, 1, 4, 1, 5, 9};
        printArray(a);
        sortArray(a);
        printArray(a);
    }

    private static void printArray(int[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private static void sortArray(int[] a) {
        int t = 0;
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length; j++) {
                if(a[i] < a[j]) {
                    t = a[j];
                    a[j] = a[i];
                    a[i] = t;
                }
            }
        }
    }
}
