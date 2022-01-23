package my_Algorithm.my_String;

import java.util.HashMap;
import java.util.Map;

public class NewTest {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat fish";
        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length() != words.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        char key;
        for(int i = 0; i < words.length; i++) {
            key = pattern.charAt(i);
            if(map.isEmpty() || (!map.containsKey(key) && !map.containsValue(words[i]))) {
                map.put(key, words[i]);
            } else if(map.containsKey(key)) {
                if(!map.get(key).equals(words[i])) {
                    return false;
                }
            } else if(map.containsValue(words[i])) {
                for(Map.Entry<Character, String> entry: map.entrySet()) {
                    if(entry.getValue().equals(words[i])) {
                        if(entry.getKey() != key) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
