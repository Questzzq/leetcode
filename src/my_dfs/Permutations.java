package my_dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};
        Arrays.sort(nums);
        List<List<Integer>> list = permutation(nums);
        System.out.println(list.size());
        for(List<Integer> li: list) {
            System.out.println(li.toString());
        }
    }

    private static List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        int len = nums.length;
        boolean[] flag = new boolean[len];
        dfs(nums, len, 0, list, tmpList, flag);
        return list;
    }

    private static void dfs(int[] nums, int len, int left,
                            List<List<Integer>> list,
                            List<Integer> tmpList, boolean[] flag) {
        list.add(new ArrayList<>(tmpList));
        for(int i = left; i < len; i++) {
//            if(!flag[i]) {
                if(i != left && nums[i]==nums[i-1]) {
                    continue;
                }
                tmpList.add(nums[i]);
                flag[i] = true;
                dfs(nums, len, left+1, list, tmpList, flag);
                tmpList.remove(tmpList.size()-1);
                flag[i] = false;
//            }
        }
    }

    private static boolean isSameList(List<Integer> l1, List<Integer> l2) {
        if(l1.size()!=l2.size()) {
            return false;
        }
        int i = l1.size()-1;
        while(i>=0) {
            if(l1.get(i)!=l2.get(i)) {
                return false;
            }
            i--;
        }
        return true;
    }
}

