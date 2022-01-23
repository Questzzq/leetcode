package my_dp;

public class MyTest {
    public static void main(String[] args) {
        int [] cost = {1,100,1,1,1,100,1,1,100,1};
//        int [] cost = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost));
    }
    public static int minCostClimbingStairs(int[] cost) {
        int costLen = cost.length;
        int[] n = new int[costLen+2];
        int[] dp = new int [costLen+2];
        dp[1] = cost[0];
        n[0] = 0;
        for(int i = 1; i <= costLen; i++) {
            n[i] = cost[i-1];
        }
        n[costLen+1] = 0;
        for(int i = 0; i < n.length; i++) {
            System.out.println(i + ": " + n[i]);
        }
        int i;
        for(i = 2; i < n.length; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-2]) + n[i];
        }
        return dp[costLen+1];
    }
}
