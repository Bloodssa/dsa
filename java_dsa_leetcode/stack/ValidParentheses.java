package java_dsa_leetcode.stack;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()[]{}";

        var res = ValidP.isValid(s);

        System.out.println(res);
    }
}

class ValidP
{
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else {
                if(stack.isEmpty()) return false;

                char last = stack.pop(); // get pop the last element if the stack is not empty case
                if(c == ')' && last != '(' || c == '}' && last != '{' || c == ']' && last != '[') {
                    return false; // its not a valid
                }
            }
        }
        // System.out.println(stack);

        return stack.isEmpty();
    }
}