package my_Algorithm;

import java.util.*;

public class TargetNums {
    public static void main(String[] args) {
        int[] nums = {0,0,0};
        Arrays.sort(nums);
        for(Integer i: nums) {
            System.out.print(i + " ");
        }
        System.out.println();
        int len = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        int pre = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++) {
            if(i >= 1 && nums[i] == pre) {
                continue;
            }
            getTarget(nums, i+1, len-1, -nums[i], list);
            pre = nums[i];
        }
        for(List<Integer> l: list) {
            for(Integer i: l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> getTarget(int[] n, int l, int r, int t, List<List<Integer>> list) {
        int sum;
        List<Integer> tmp = new ArrayList<>();
        int preL = 2;
        int preR = 1;
        while(l<r) {
            sum = n[l]+n[r];
            if(sum == t) {
                if(n[l]==preL && n[r]==preR) {
                    l++;
                    r--;
                    continue;
                }
                preL = n[l];
                preR = n[r];
                tmp.add(-sum);
                tmp.add(n[l]);
                tmp.add(n[r]);
                list.add(new ArrayList<>(tmp));
                tmp.clear();
                l++;
                r--;
            }
            else if(sum > t) {
                r--;
            }
            else {
                l++;
            }
        }
        return list;
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        return null;
    }
}
