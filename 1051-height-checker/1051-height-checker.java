class Solution {
    public int heightChecker(int[] heights) {
        int[] s=new int[heights.length];
        int i=0;
        for(int j:heights){
            s[i++]=j;
        }
        Arrays.sort(s);
        int out=0;
        for(i=0;i<heights.length;i++){
            if(s[i]!=heights[i]){
                out++;
            }
        }
            
        return out;
    }
}