import java.util.*;

class Solution {
    HashSet<String> set;
    int[] m ;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        m = new  int[s.length()+1];
        for(String val : wordDict){
            set.add(val);
        }
        return solve(0,s);
    }
    
    public boolean solve(int idx, String s){
        // System.out.println(idx);
        
        if(idx == s.length()){
            return true;
        }
        if(m[idx] == 1){
            return true;
        }
        else if(m[idx] == 2){
            return false;
        }
        
        
        for(int i = idx ; i < s.length() ; i++){
            if(set.contains(s.substring(idx,i+1)) && solve(i+1,s)){
                m[idx] = 1;
                return true;
            }
            // System.out.println(s.substring(idx,i+1) + " " + set.contains(s.substring(idx,i+1)));
        }
        m[idx] = 2;
        return false;
    }
}