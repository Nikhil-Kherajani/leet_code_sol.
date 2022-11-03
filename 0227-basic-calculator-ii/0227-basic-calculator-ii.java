class Solution {
    public int calculate(String s) {
        int res=0,curr=0,i=0,n=s.length();
        char op='+';
        Stack<Integer> stack = new Stack<Integer>();
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch))
                curr=curr*10+ch-'0';

            if(i==n-1 || (!Character.isDigit(ch) && ch!=' ')){
                if(op=='+')
                    stack.push(curr);
                else if(op=='-')
                    stack.push(-curr);
                else if(op=='*')
                    stack.push(curr*stack.pop());
                else if(op=='/')
                    stack.push(stack.pop()/curr);
                op=ch;
                curr=0;
            }i++;
        }
        while(!stack.isEmpty()) res+=stack.pop();
        return res;
    }
}