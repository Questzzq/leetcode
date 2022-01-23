package my_dfs;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("1231");
        List<Integer> list = grayCode(2);
        System.out.println(list);
    }

    public static List<Integer> grayCode(int n) {
        int[] nums = {0, 1};
        List<Integer> list = new ArrayList<>(n);
        String path = "";
        dfs(list, path, nums, new boolean[n], 0, n);
        return list;
    }

    private static void dfs(List<Integer> list, String path, int[] nums,
                     boolean[] flag,  int left, int n) {
        if(path.length() == n) {
            list.add(getIntegerByChar(path));
            return;
        }
        for(int i = left; i < 2; i++) {
            if(!flag[i]) {
                path += String.valueOf(nums[i]);
                flag[i] = true;
                dfs(list, path, nums, flag, i+1, n);
                flag[i] = false;
                path = path.substring(0, path.length());
            }
        }
    }

    private static int getIntegerByChar(String s) {
        int res = 0;
        int len = s.length();
        for(int i = 0; i < len; i++) {
            res += (int) (s.charAt(i)-'0') *Math.pow(2, len-i-1);
        }
        return res;
    }
}
