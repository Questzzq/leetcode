package my_dfs;

import java.util.*;

public class MyTest {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 8};
        List<List<Integer>> resList = permute(nums);
        System.out.println(resList);
    }

//    private static void printList(List<List<Integer>> list) {
//        for(List<Integer> li: list) {
//            for(Integer i: li) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
//    }

    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if(depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if(used[i]) {
               continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth+1, path, used, res);
            path.removeLast();
            used[i] = false;
        }
    }


}
