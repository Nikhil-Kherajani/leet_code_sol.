import java.util.*;

class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
                size = Math.max(size, stack.size());
            } else if (s.charAt(i) == ')') {
                stack.pop();
            }
        }
        return size;
    }
}