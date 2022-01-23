package my_dp;

public class NewTest {
    public static void main(String[] args) {
        int[] nums = {8,-15,-29,-19};
        System.out.println(maxSubarraySumCircular(nums));
    }
    public static int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }
        if(len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 分类讨论，横跨的情况，需要逆向思维，
        // 求下标[1, len-2]之间的最小连续和，再用总数减去最小连续和
        int[] dp = new int[len];
        int sum = 0;
        for(int i = 0; i < len; i++) sum += nums[i];
        dp[1] = nums[1];
        int min = dp[1];
        for(int i = 2; i < len-1; i++) {
            dp[i] = Math.min(dp[i-1]+nums[i], nums[i]);
            if(dp[i] < min) {
                min = dp[i];
            }
        }
        int max1 = sum-min;

        // 没有横跨的情况
        dp[0] = nums[0];
        int max2 = dp[0];
        for(int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            if(dp[i] > max2) {
                max2 = dp[i];
            }
        }
        return Math.max(max1, max2);
    }
}
