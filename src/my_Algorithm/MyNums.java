package my_Algorithm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class MyNums {
    public static int findKthLargest(int[] nums, int k) {
        int p = k-1;
        int t;
        int[] array = new int[k];
        Arrays.fill(array, Integer.MIN_VALUE);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < p; j++) {
                if(nums[i] >= array[j]) {
                    for(t = p; t > j; t--) {
                        array[t] = array[t-1];
                    }
                    array[t] = nums[i];
                }
            }
        }
        for(int i = 0; i <= p; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        return array[p];
    }
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        findKthLargest(nums, k);
//        int m, n;
//        System.out.println((char)('A' + 3));
//        while(true) {
//            Scanner scanner = new Scanner(System.in);
//            while (scanner.hasNextLine()) {
//                m = scanner.nextInt();
//                n = scanner.nextInt();
//                System.out.println(getResult(m, n));
//            }
//        }

    }

    /**
     * 将十进制的m转换为n进制的数
     * @param m 待转化的数
     * @param n 进制
     * @return n进制的m
     */
    private static String getResult(int m, int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = m>0;
        m = Math.abs(m);
        while(m>0) {
            System.out.println(m%n);
            stack.push(m%n);
            m = m/n;
        }
        while(!stack.isEmpty()) {
            m = stack.pop();
            if(m<10) {
                sb.append((char) ('0'+m));
            } else {
                sb.append((char) ('A'+(m-10)));
            }
        }
        return flag?sb.toString():"-"+ sb;
    }
}
