package my_string;

import java.util.*;

@SuppressWarnings("all")
public class MyTest {
    public static void main(String[] args) {
//        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
//        System.out.println(threeSum1(nums));
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        if(s == null) return true;
        s = s.toLowerCase();
        System.out.println(s);
        int i = 0;
        int j = s.length()-1;
        while(i<j) {
            if(s.charAt(i) == ' ') {
                i++;
                continue;
            }
            if(s.charAt(j)==' ') {
                j--;
                continue;
            }
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        int len = nums.length;
        List<List<Integer>> resList = new ArrayList<>();
        if(len < 3)
            return resList;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        int l = 0;
        int r = 0;
        int t = 0;
        int s = 0;
        for(int i = 0; i < len-2; i++) {
            if(nums[i] > 0) break;
            if(nums[i] == nums[i+1]) {
                continue;
            }
            List<Integer> list = new ArrayList<>();
            t = -nums[i];
            l = i+1;
            r = len-1;
            while(l < r) {
                for(int k = l+1; k < r; k++) {
                    if(nums[l] == nums[k]) {
                        l++;
                    }
                }
                s = nums[l] + nums[r];
                if(s == t) {
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    resList.add(new ArrayList<>(list));
                    list.clear();
                } else if(s > t) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return resList;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3)
            return new ArrayList<>();
        List<List<Integer>> resList = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            List<List<Integer>> list = twoSum(nums, 0-nums[i], i);
            for(List<Integer> li: list) {
                if(!li.isEmpty()) {
                    resList.add(li);
                }
            }
        }
        // 去重
        return resList;
    }

    public static List<List<Integer>> twoSum(int[] nums, int target, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for(int i = 0; i < len && i != k; i++) {
            if(map.isEmpty() || !map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }else {
                map.put(nums[i], map.get(nums[i])+1);
            }
        }
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < len && i != k; i++) {
            list.clear();
            if(map.containsKey(target-nums[i])) {
                if(nums[i] == target - nums[i]) {
                    if(map.get(target-nums[i]) < 2) {
                        break;
                    }
                }
                list.add(nums[k]);
                list.add(nums[i]);
                list.add(target-nums[i]);
                resList.add(list);
            }
        }
        return resList;
    }
}
