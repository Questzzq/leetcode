package my_string;

import java.util.Scanner;

public class StringSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String source = scanner.nextLine();
            String target = scanner.nextLine();
            System.out.println(source);
            System.out.println(target);
            isExisted(source, target);
        }
    }

    private static void isExisted(String source, String target) {
        int len1 = source.length();
        int len2 = target.length();
        if(len2 > len1) {
            System.out.println(false);
        }

    }
}
