package my_Algorithm.my_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int n = 3;
        List<Integer> list = gC(n);
        System.out.println(list);
//        int[] nums = {0, 0, 2, 1};
//        System.out.println(dominantIndex(nums));
    }

    private static List<Integer> gC(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        int p = 1;
        int s = (int)Math.pow(2, n);
        while(list.size() < s) {
            p *= 2;
            for(int j = list.size()-1; j >= 0; j--) {
                list.add(p+list.get(j));
            }
        }
        return list;
    }

    public static List<Integer> grayCode(int n) {
        int s = (int)Math.pow(2, n);
        List<Integer> list = new ArrayList<>(n);
        List<Integer> nums = new LinkedList<>();
        for(int i = 1; i < s; i++) {
            nums.add(i);
        }
        int pre = 0;
        list.add(0);
        int cur;
        System.out.println(nums);
        Iterator iter = nums.listIterator();
        while(iter.hasNext()) {
            cur = (int) iter.next();
            if(isRight(cur ^ pre)) {
                list.add(cur);
                pre = cur;
                iter.remove();
                iter = nums.listIterator();
            }
        }
        return list;
    }

    private static boolean isRight(int n) {
        if(n == 1) return true;
        int i = 1;
        while(i <= n) {
            i*=2;
            if(i == n) {
                return true;
            }
        }
        return false;
    }

    public static int dominantIndex(int[] nums) {
        int max = nums[0];
        int index = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > max) {
                index = i;
            }
        }
        max = nums[index];
        for(int i = 0; i < nums.length; i++) {
            if(i == index) continue;
            if(nums[i]*2 > max) {
                return -1;
            }
        }
        return index;
    }
}
