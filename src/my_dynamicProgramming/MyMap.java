package my_dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class MyMap {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] res = twoSum(nums, 6);
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i] +" ");
        }
//        int[][] map = {{1,2,3},{4,5,6}};
//        int m = map.length;
//        int n = map[0].length;
//        System.out.println(getResult(map, m, n));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.isEmpty() || !map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]));
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                if(nums[i] == target-nums[i]) {
                    if(map.get(nums[i]) > 1) {
                        result[0] = nums[i];
                        result[1] = nums[i];
                        break;
                    }
                } else {
                    result[0] = nums[i];
                    result[1] = target-nums[i];
                    break;
                }
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == result[0]) {
                result[0] = i;
                break;
            }
        }
        for(int i = 0; i < nums.length && i != result[0]; i++) {
            if(nums[i] == result[1]) {
                result[1] = i;
                break;
            }
        }
        return result;
    }

    private static int getResult(int[][] map, int m, int n) {
        int result = 0;
        if(m==1) {
            for(int i = 0; i < n; i++) {
                result += map[0][i];
            }
            return result;
        }
        if(n==1) {
            for(int i = 0; i < m; i++) {
                result += map[i][0];
            }
            return result;
        }
        for(int i = 1; i < n; i++) {
            map[0][i] += map[0][i-1];
        }
        for(int i = 1; i < m; i++) {
            map[i][0] += map[i-1][0];
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                map[i][j] = map[i-1][j] > map[i][j-1] ? map[i][j]+map[i-1][j]: map[i][j]+map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }
}
