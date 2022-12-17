class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>() ;
        Set<String> o = new HashSet<>(Arrays.asList("+", "-", "*", "/")) ;
        for (String i:tokens) 
        {
            if(!o.contains(i)) 
                stack.push(Integer.valueOf(i));
            else 
            {
                int a = stack.pop(), b = stack.pop();
                if(i.equals("+")) 
                    stack.push(a + b);
                else if(i.equals("-")) 
                    stack.push(b - a);
                else if(i.equals("*")) 
                    stack.push(a*b);
                else 
                    stack.push(b/a);
            }
        }
        return stack.peek() ;
    }
}