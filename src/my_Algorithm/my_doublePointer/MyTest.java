package my_Algorithm.my_doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        Arrays.sort(nums);
        List<List<Integer>> list = fourSum(nums, 0);
        for(List<Integer> li: list) {
            System.out.println(li);
        }
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length-4; i++) {
            List<List<Integer>> threeSumList = threeSum(nums, target-nums[i], i+1);
            for(List<Integer> li: threeSumList) {
                li.add(0, nums[i]);
                if(!list.contains(li)) {
                    list.add(new ArrayList<>(li));
                }
            }
        }
        return list;
    }

    private static List<List<Integer>> threeSum(int[] nums, int target, int l) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = l; i < nums.length-3; i++) {
            List<List<Integer>> twoSumList = twoSum(nums, target-nums[i], i+1);
            for(List<Integer> li: twoSumList) {
                li.add(0, nums[i]);
                if(!list.contains(li)) {
                    list.add(new ArrayList<>(li));
                }
            }
        }
        return list;
    }

    private static List<List<Integer>> twoSum(int[] nums, int t, int l) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        int r = nums.length-1;
        int s;
        while(l < r) {
            s = nums[l]+nums[r];
            if(s==t) {
                tmpList.add(nums[l++]);
                tmpList.add(nums[r--]);
                if(!list.contains(tmpList)) {
                    list.add(new ArrayList<>(tmpList));
                }
                tmpList.clear();
            } else if(s > t) {
                r--;
            } else {
                l++;
            }
        }
        return list;
    }




}
