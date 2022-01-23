package my_Algorithm.my_String;

import java.util.HashMap;
import java.util.Map;

public class MyTest {
    public static void main(String[] args) {
//        String s = "foo";
//        System.out.println(getResult(s));
//        String t = "bar";
//        String[] tt = t.split("-");
//        System.out.println(isIsomorphic(s, t));

        int[] nums = {1,2,3,1,2,3};
        int t = 2;
        System.out.println(containsNearbyDuplicate(nums, t));
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        for(int i = 0; i < len-k; i++) {
            for(int j = 1; j <= k; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String getResult(String s) {
        int len = s.length();
        int begin = 0;
        int maxLen = 1;
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for(int j = 0; j < len; j++) {
            for(int i = 0; i < j; i++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(j-i<3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j]= dp[i+1][j-1];
                    }
                }
                if(dp[i][j] && j-i+1 > maxLen) {
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, maxLen+begin);
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s.equals(t))
            return true;
        Map<Character, Character> map = new HashMap<>();
        map.put(s.charAt(0), t.charAt(0));
        char key, value;
        for(int i = 1; i < s.length(); i++) {
            key = s.charAt(i);
            value = t.charAt(i);
            if(!map.containsKey(key) || !map.containsValue(value)) {
                map.put(key, value);
            } else if(map.containsKey(key) && map.containsValue(value)) {
                if(map.get(key)!=value) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
