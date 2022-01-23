package my_linkNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum {
    public static void main(String[] args) {
        int[] list = new int[]{-3, 2, -4, 0, 9, 4, 4, 1, 5, 8, 3, 2, -13};
        int[] res = twoSum(list, 8);
        System.out.println(res[0]);
        System.out.println(res[1]);
//        List<List<Integer>> result = threeSum(list);
//        for(int i = 0; i < result.size(); i++) {
//            List<Integer> tmp = result.get(i);
//            for(Integer integer: tmp) {
//                System.out.print(integer + " ");
//            }
//            System.out.println();
//        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.isEmpty() && map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for(int i = 0; i < nums.length; i++) {

        }
        return null;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        boolean flag = true;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length && j != i; j++) {
                if(nums[j] == target - nums[i]) {
                    result[0] = i;
                    result[1] = j;
                    flag = false;
                    break;
                }
                if(!flag)
                    break;
            }
        }
        return result;
    }
}
