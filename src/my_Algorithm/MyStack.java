package my_Algorithm;

import java.util.Stack;

public class MyStack {
    public static boolean isValid(String s) {
        // 21:22
        long res = 1;
        int sum = 0;
        if(s.length() < 2 ||  s.length()%2==1)
            return false;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                sum++;
            } else {
                sum--;
            }
        }
        if(sum != 0)
            return false;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                char t = stack.peek();
                char n = ')';
                if(ch == ']') {
                    n = '[';
                } else if(ch == '}') {
                    n = '{';
                }
                while(t != n && !stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
