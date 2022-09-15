class Solution {
    public String truncateSentence(String s, int k) {
        int count=0;
        StringBuilder sb = new StringBuilder();
        StringBuilder st = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                st.append(s.charAt(i));
            }
            else{
                count++;
                sb.append(st.toString());
                if(count==k)
                    return sb.toString();
                sb.append(" ");
                st.setLength(0);
            }
        }
        sb.append(st.toString());
        return sb.toString();
    }
}