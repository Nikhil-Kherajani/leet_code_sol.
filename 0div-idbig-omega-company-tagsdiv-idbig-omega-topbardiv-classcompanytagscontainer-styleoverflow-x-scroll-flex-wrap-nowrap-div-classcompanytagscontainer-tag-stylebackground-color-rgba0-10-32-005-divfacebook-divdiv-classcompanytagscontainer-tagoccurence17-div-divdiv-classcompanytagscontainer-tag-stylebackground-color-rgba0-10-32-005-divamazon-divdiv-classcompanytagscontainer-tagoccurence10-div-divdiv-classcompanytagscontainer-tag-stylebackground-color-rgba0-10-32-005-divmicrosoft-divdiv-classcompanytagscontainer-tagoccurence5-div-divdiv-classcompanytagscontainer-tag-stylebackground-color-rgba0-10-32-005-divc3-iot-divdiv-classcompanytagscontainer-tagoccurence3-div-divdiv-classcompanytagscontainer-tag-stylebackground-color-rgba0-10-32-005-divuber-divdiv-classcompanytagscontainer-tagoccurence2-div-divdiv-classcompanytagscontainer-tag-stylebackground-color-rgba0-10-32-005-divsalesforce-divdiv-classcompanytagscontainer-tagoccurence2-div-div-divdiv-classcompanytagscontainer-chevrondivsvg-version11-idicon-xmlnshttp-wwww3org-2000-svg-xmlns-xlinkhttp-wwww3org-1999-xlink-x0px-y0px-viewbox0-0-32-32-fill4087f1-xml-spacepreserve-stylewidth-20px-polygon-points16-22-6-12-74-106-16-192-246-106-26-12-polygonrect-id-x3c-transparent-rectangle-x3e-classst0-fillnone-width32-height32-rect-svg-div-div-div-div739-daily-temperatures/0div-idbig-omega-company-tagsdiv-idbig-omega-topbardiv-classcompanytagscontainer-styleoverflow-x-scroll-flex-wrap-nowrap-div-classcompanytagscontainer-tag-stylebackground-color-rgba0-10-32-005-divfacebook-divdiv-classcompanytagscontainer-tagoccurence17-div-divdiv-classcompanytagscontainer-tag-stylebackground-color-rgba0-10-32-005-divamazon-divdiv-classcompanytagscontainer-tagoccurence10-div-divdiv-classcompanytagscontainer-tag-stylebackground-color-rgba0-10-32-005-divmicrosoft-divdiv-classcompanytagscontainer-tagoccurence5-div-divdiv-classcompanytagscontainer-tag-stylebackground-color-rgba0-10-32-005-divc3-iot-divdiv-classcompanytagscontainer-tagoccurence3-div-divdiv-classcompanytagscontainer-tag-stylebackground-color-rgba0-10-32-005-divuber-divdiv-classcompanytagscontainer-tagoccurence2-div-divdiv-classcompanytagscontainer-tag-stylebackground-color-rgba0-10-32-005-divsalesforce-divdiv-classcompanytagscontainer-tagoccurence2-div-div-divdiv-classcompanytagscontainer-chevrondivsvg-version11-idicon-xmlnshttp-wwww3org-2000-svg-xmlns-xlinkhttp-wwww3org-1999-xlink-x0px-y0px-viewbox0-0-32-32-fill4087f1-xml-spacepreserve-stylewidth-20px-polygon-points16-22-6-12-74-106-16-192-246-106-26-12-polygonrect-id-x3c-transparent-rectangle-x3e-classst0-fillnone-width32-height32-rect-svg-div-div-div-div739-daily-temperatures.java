import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] t) {
       Stack<Integer> st = new Stack<>();
       int[] res = new int[t.length];
       for(int i=t.length-1;i>=0;i--) 
       {
           while(!st.isEmpty()&&t[i]>=t[st.peek()])
           {
               st.pop();
           }
           if(!st.isEmpty())
           res[i]=st.peek()-i;
           st.push(i);
       }
    return res;
    
}
}