package my_Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MyTest {
    public static void main(String[] args) {
        int[]a = {1, 2, 3};
    }

    public static int getMaxProfit(int[] prices) {
        int res = 0;
        int len = prices.length;
        int[][] p = new int[len][2];
        for(int i = 0; i < len; i++) {
            p[i][0] = prices[i];
            p[i][1] = i;
        }
        Arrays.sort(p, new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                return p1[0] - p2[0];
            }
        });
        int pro = 0;
        for(int i = 0; i < len; i++) {
            for(int j = len-1; j > i; j--) {
                pro = p[j][0] - p[i][0];
                if(p[j][1] > p[i][1] && res < pro) {
                    res = pro;
                }
            }
        }
        return res;
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length < 2)
            return 0;
        goodSort(intervals);
        for(int i = 0; i < intervals.length; i++) {
            for(int j = 0; j < intervals[i].length; j++) {
                System.out.print(intervals[i][j] + " ");
            }
            System.out.println();
        }
        int res = 1;
        int preEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= preEnd) {
                res++;
                preEnd = intervals[i][1];
            }
        }
        return intervals.length - res;
    }

    private static void goodSort(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });
    }

    private static void sort(int[][] a) {
        Arrays.sort(a, (o1, o2) -> {
            if(o1[1]==o2[1]) {
                return o1[0]-o2[0];
            } else {
                return o1[1]-o2[1];
            }
        });
    }

    private static void sort1(int[][] a) {
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]) {
                    return o1[0]-o2[0];
                } else {
                    return o1[1]-o2[1];
                }
            }
        });
    }

    public static int maxProfit(int[] prices) {
        if(prices.length < 2) {
            return 0;
        }
        boolean[] flag = new boolean[prices.length];
        for(int i = 0; i < prices.length; i++) {
            flag[i] = true;
        }
        int res = 0;
        for(int i = 0; i < prices.length && flag[i]; i++) {
            int buy = prices[i];
            for(int j = i+1; j < prices.length; j++) {
                if(j < prices.length-1) {
                    if(prices[j] > buy && flag[j] && prices[j+1] <= prices[j]) {
                        res = res + prices[j] - buy;
                        flag[j] = false;
                        flag[i] = false;
                        i = j-1;
                        System.out.println("res: " + res);
                        break;
                    }
                } else {
                    if(prices[j]>buy && flag[j]) {
                        i = j-1;
                        flag[j] = false;
                        res = res + prices[j] - buy;
                        System.out.println("res: " + res);
                    }
                }
            }
        }
        return res;
    }
}