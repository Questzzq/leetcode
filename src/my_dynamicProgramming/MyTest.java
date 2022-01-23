package my_dynamicProgramming;

import java.util.Arrays;

public class MyTest {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        String s = "aacabdkacaa";
        System.out.println(s);
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i>=0; i--) {
            sb.append(s.charAt(i));
        }
        String revS = sb.toString();
        System.out.println(revS);
        String c = getLongestCommonString(s, revS);
        System.out.println(c);
    }

    private static String getLongestCommonString(String a, String b) {
        if(a==null||b==null) {
            return null;
        }
        int[][] p = new int[a.length()+1][b.length()+1];
        for(int i = 0; i <= a.length(); i++) {
            for(int j = 0; j <= b.length(); j++)
                p[i][j] = 0;
        }
        int index = 0;
        int max = 0;
        for(int i = 0; i < a.length(); i++) {
            for(int j = 0; j < b.length(); j++) {
                if(a.charAt(i) == b.charAt(j)) {
                    p[i+1][j+1] = p[i][j]+1;
                    if(max<=p[i+1][j+1]) {
                        max = p[i+1][j+1];
                        index = i-max+1;
                    }
                }
            }
        }
        System.out.println("max: " + max);
        return a.substring(index, index+max);
    }
}
