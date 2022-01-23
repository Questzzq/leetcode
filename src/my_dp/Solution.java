package my_dp;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int res = 1;
        for(int i = 1; i < len; i++) {
            for(int j = i-1; j >= 0; j--) {
                if(dp[i] > dp[j]) {
                    dp[i] = dp[j]+1;
                    break;
                }
            }
            if(dp[i] > res) {
                res = dp[i];
            }
        }
        for(int i: dp) {
            System.out.print(i + " ");
        }
        return res;
    }

    public static boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int t;
        for(int i = 1; i < len; i++) {
            dp[i] = 1;
            t = 0;
            if(nums[i] > nums[i-1]) {
                dp[i] = dp[i-1]+1;
            } else {
                for(int j = i-2; j >= 0; j--) {
                    if(nums[i] > nums[j] && dp[j] > t) {
                        t = dp[j];
                    }
                }
                if(t > 0) {
                    dp[i] = t+1;
                }
            }
            System.out.println(dp[i]);
            if(dp[i] >= 3) {
                return true;
            }
        }
        return false;
    }
}
