class Solution {
    public String interpret(String command) {
        String ans = "";
        for(int i = 0 ; i < command.length() ; i++)
        {
            if((command.charAt(i)>='a' && command.charAt(i)<='z') || (command.charAt(i)>='A' && command.charAt(i)<='Z'))
            {
                ans=ans+command.charAt(i);
            }
            else if(i<command.length()-1 && command.charAt(i)=='(' && command.charAt(i+1)==')' )
            {
                ans = ans+'o';
            }
            else
                continue;
        }
        return ans;
    }
}