class Solution {
    public String sortSentence(String s) {
        String[] str = s.split(" ");
        String[] res = new String[str.length];
        int temp ;
        for(int i=0;i<str.length;i++){
            temp=str[i].charAt(str[i].length()-1)-'0';
            res[temp-1]=str[i].substring(0,str[i].length()-1);
        }
        String ss="";
        for(int i=0;i<res.length;i++){
            ss+=res[i];
            if(i!=res.length-1)
                ss+=" ";
        }
        return ss;
    }
}