package my_Algorithm.my_String;

import java.util.HashMap;
import java.util.Map;

public class DeleteNums {
    public static void main(String[] args) {
        int[] nums = {3,4,2};
        System.out.println(deleteAndEarn(nums));
    }

    public static int deleteAndEarn(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            if(map.isEmpty() || !map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i])+1);
            }
        }
        for(int i = 0; i < len; i++) {
            Map<Integer, Integer> m = new HashMap<>(map);
            res[i] = helper(nums[i], m);
        }
        for(int i = 1; i < len; i++) {
            if(res[i] > res[0]) {
                res[0] = res[i];
            }
        }
        return res[0];
    }

    private static int helper(int num, Map<Integer, Integer> map) {
        if(!map.containsKey(num) || map.get(num) == 0) {
            return 0;
        }
        int mul = map.get(num);
        map.put(num, 0);
        return num*mul + helper(num+1, map) + helper(num-1, map);
    }
}
