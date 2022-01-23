package my_Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4, 10, 20};
        int target = 15;
        int len = nums.length;
        int sum;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < len-2; i++) {
            for(int j = i+1; j < len-1; j++) {
               sum = nums[i]+nums[j];
               list.add(sum+getNearestNum(nums, target-sum, j+1));
            }
        }
    }

    // 找出最接近的数
    private static int getNearestNum(int[] nums, int target, int l) {
        int r = nums.length-1;
        int mid = 0;
        boolean flag = false;
        while(l<=r) {
            mid = l+(r-l)/2;
            if(nums[mid]==target) {
                flag = true;
                break;
            } else if(nums[mid] > target) {
                r--;
            } else {
                l++;
            }
        }
        if(flag) {
            return nums[mid];
        }
        return Math.abs(target-nums[l]) < Math.abs(target-nums[r])? nums[l]:nums[r];
    }

    public static int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        int len = nums.length;
        int t;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < len-1; i++) {
            for(int j = i+1; j < len; j++) {
                sum = nums[i]+nums[j];
                t = getNearestIndex(nums, target-sum);
                list.add(sum+nums[t]);
            }
        }
        int res = target;
        int min = Integer.MAX_VALUE;
        for(Integer num: list) {
            t = num-target;
            if(Math.abs(t)<min) {
                res = num;
                min = Math.abs(t);
            }
        }
        return res;
    }

    private static int getNearestIndex(int[] nums, int target) {
        if(target <= nums[0]) {
            return 0;
        }
        if(target >= nums[nums.length-1]) {
            return nums.length-1;
        }
        int l = 0;
        int r = nums.length-1;
        int mid;
        while(l <= r) {
            mid = l+(r-l)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return Math.abs(nums[l]-target) < Math.abs(target-nums[r])? l:r;
    }
}
