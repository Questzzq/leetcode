package my_Sort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a = {3,30,34,5,9};
        String[] s = new String[a.length];
        for(int i = 0; i < a.length; i++) {
            s[i] = String.valueOf(a[i]);
        }
        Arrays.sort(s);
        System.out.println(Arrays.toString(s));
    }
}
