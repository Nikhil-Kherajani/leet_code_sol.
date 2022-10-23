class Solution {
    public String robotWithString(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            lastSeen.put(s.charAt(i), i);
        Set<Integer> used = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int preEnd = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            while (!stack.isEmpty() && stack.peek() <= c) sb.append(stack.pop());
            if (!lastSeen.containsKey(c)) continue;
            int last = lastSeen.get(c);
            for (int i = preEnd; i <= last; i++) {
                char cur = s.charAt(i);
                if (used.add(i)) {
                    if (cur == c) sb.append(cur);
                    else stack.add(cur);
                }
            }
            preEnd = last + 1;
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}