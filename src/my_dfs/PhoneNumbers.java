package my_dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumbers {
    public static void main(String[] args) {
        String digits = "23464545";
        letterCombinations(digits);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits == null || digits.length() < 1) {
            return list;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");map.put('3', "def");map.put('4', "ghi");
        map.put('5', "jkl");map.put('6', "mno");map.put('7', "pqrs");
        map.put('8', "tuv");map.put('9', "wxyz");
        backtrack(list, new StringBuilder(), digits, map);
        for(String s: list) {
            System.out.print(s + " ");
        }
        System.out.println();
        return list;
    }

    private static void backtrack(List<String> list, StringBuilder path,
                            String digits, Map<Character, String> map) {
        if(path.length()==digits.length()) {
            list.add(path.toString());
            return;
        }
        String s = map.get(digits.charAt(path.length()));
        for(int i = 0; i < s.length(); i++) {
            path.append(s.charAt(i));
            backtrack(list, path, digits, map);
            path.deleteCharAt(path.length()-1);
        }
    }
}
