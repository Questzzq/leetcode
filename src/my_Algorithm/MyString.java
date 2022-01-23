package my_Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyString {
    public static String replaceSpace(String s) {
        int a = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder(s);
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                sb.insert(i+j, "%20");
                j = j+2;
            }
        }
        return sb.toString();
    }

    public static int myAtoi(String s) {
        if(s == null || s.length() < 0) {
            return 0;
        }
        char c = ' ';
        int start = 0;
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                sb.append(String.valueOf(c));
            } else {
                if(c == '-') {
                    flag = false;
                }
            }
        }
        String digits = "";
        if(sb != null) {
            digits = sb.toString();
        }
        for(int i = 0; i < digits.length(); i++) {
            if(digits.charAt(i)!='0') {
                start = i;
                break;
            }
        }
        StringBuilder sbs = new StringBuilder();
        for(int i = start; i < digits.length(); i++) {
            sbs.append(digits.charAt(i));
        }
        digits = sbs.toString();
        double maxValue = Math.pow(2, 31) - 1;
        double minValue = Math.pow(2, 31);
        String maxS = String.valueOf(maxValue);
        String minS = String.valueOf(minValue);
        int res = 0;
        int t = 0;
        if(flag) {
            t = digits.compareTo(maxS);
            if(t > 0) {
                digits = maxS;
            }
        } else {
            t = digits.compareTo(minS);
            if(t > 0) {
                digits = minS;
            }
        }
        res = Integer.valueOf(digits);
        return flag?res:-res;
    }

    public static void main(String[] args) {
//        String s = "ba  b ad";
//        System.out.println(replaceSpace(s));
//        System.out.println(lengthOfLongestSubstring(s));
//        int[] nums1 = {1, 2};
//        int[] nums2 = {3, 4};
//        System.out.println(findMedianSortedArrays(nums1, nums2));
//        String[] strs = new String[3];
//        strs[0] = "flower";
//        strs[1] = "flow";
//        strs[2] = "flight";
//        System.out.println(longestCommonPrefix(strs));
        String a = "23";
        System.out.println(myAtoi(a));
//        letterCombinations(a);
    }

    public static List<String> letterCombinations(String digits) {
        //00:20
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int n = 1;
        for(int i = 0; i < digits.length(); i++) {
            if(digits.charAt(i)=='7'||digits.charAt(i)=='9') {
                n *= 4;
            } else {
                n *= 3;
            }
        }
        List<String> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(i, "");
        }
        for(int i = 0; i < digits.length(); i++) {
            generateResultsByTwoStrings(list, letters[digits.charAt(i)-'2']);
        }
        list.forEach(System.out::println);
        return list;
    }

    private static void generateResultsByTwoStrings(List<String> list, String a) {
        for(int j = 0; j < a.length(); j++) {
            for(int i = 0; i < a.length(); i++) {
                String t = String.valueOf(a.charAt(i));
                System.out.println("index = " + i*a.length()+j);
//                list.set(i * a.length() + j, list.get(i*a.length()+j) + t);
            }
        }
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length < 2) {
            return strs[0];
        }
        int len = strs[0].length();
        int p = 0;
        for(int i = 0; i < strs.length; i++) {
            if(strs[i].length() < len) {
                len = strs[i].length();
                p = i;
            }
        }
        String ss = strs[p];
        int t = len; // 第一次循环认为最长公共前缀的长度为最短串的长度
        int h = 0;   // 每次循环匹配到的公共前缀的长度
        for(int i = 0; i < strs.length; i++) {
            for(int j = 0; j < len && j < t; j++) {
                if(ss.charAt(j) != strs[i].charAt(j)) {
                    t = j;
                    break;
                }
            }
        }
        return ss.substring(0,t);
    }

    public static String longestPalindrome(String s) {
        if(s.length() <= 1)
            return s;
        int len = s.length();
        int p1, p2, j, l, r;
        l = 0;
        r = 0;
        for(int i = 0, t = 0; i < s.length(); i++) {
            t = 1;
            for(j = i - 1, p1 = j, p2 = j; j >= 0 && i+i+j<len; j--) {
                if(s.charAt(j) == s.charAt(i+i-j)) {
                    t+=2;
                    p1 = j;
                    p2 = i+i-j;
                } else {
                    if(t > l) {
                        l = t;
                        r = i+t-1;
                    }
                }
            }
        }

        return s.substring(r-l+1, r);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] n = new int[nums1.length+nums2.length];
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while(p1 < nums1.length && p2 < nums2.length) {
            if(nums1[p1] < nums2[p2]) {
                n[p++] = nums1[p1++];
            } else {
                n[p++] = nums2[p2++];
            }
        }
        while(p1 < nums1.length) {
            n[p++] = nums1[p1++];
        }
        while(p2 < nums2.length) {
            n[p++] = nums2[p2++];
        }
        if(n.length%2>0) {
            return n[n.length/2];
        } else {
            return (n[n.length/2]+n[n.length/2-1])/2.0;
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        // 23:07
        if(s.length() == 0 || s.length() == 1)
            return s.length();
        int j = 0;
        int max = 1;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.isEmpty()) {
                map.put(s.charAt(i), i);
                j++;
                continue;
            }
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                j++;
            } else {
                j = 0;
                i = map.get(s.charAt(i));
                map.clear();
            }
            if(max < j) {
                max = j;
            }
        }
        return max;
    }
}
