class Solution {
    public String removeOuterParentheses(String s) {
        //Get the start and end indices, 
        //where the level start to 1 and reduces to zero
        //then remvoe those indices.
        
        final StringBuilder sb = new StringBuilder();
        int len = s.length();
       
        int level = 0;
        
        for(int i = 0; i < len; ++i){
            char ch = s.charAt(i);
            
            if(ch == '(') ++level;
            
            if(level > 1) sb.append(ch);
            
            if(ch == ')') --level;
            
                
        }
        
        return sb.toString();
    }
}