package my_Sort;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,0};
        Test test = new Test();
        System.out.println(test.minNumber(a));
    }

    public String minNumber(int[] nums) {
        StringBuilder res = new StringBuilder();
        String[] s = new String[nums.length];
        int i = 0;
        for(; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s, (o1, o2) -> {
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            return (s1+s2).compareTo(s2+s1);
        });
        for(i = 0; i < s.length; i++) {
            res.append(s[i]);
        }
        i = 0;
        for(; i < res.length(); i++) {
            if(res.charAt(i) != '0') {
                break;
            }
        }
        return res.substring(i);
    }
}
