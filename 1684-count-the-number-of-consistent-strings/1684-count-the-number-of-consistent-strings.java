class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int res=words.length;  
        boolean[] alpha=new boolean[26];  
     
        for(int i=0;i<allowed.length();i++)
            alpha[allowed.charAt(i)-'a']=true;  
        
        for(String str:words)  
            for(int i=0;i<str.length();i++)
                if(alpha[str.charAt(i)-'a']==false)  
                {
                    res--;
                    break;
                }
        return res;
    }
}