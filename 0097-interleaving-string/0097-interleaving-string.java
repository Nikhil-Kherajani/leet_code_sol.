class Solution {
    boolean[][] vis;
    public boolean isInterleave(String s1, String s2, String s3) {
        vis = new boolean[s1.length()+1][s2.length()+1];

        if(s1.length() + s2.length() != s3.length())
            return false;
        
        return traverse(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0);
    }
    public boolean traverse(char[] s1, char[] s2, char[] s3, int indexS1, int indexS2, int indexS3)
    {
        
        if(indexS1 == s1.length && indexS2 == s2.length && indexS3 == s3.length)
            return true;
        
        
        if(vis[indexS1][indexS2])
            return false;
        
        vis[indexS1][indexS2] = true;
        boolean s1Plus = false;
        boolean s2Plus = false;

        if(indexS1 < s1.length && s1[indexS1] == s3[indexS3] )
            s1Plus = traverse(s1, s2, s3, indexS1 + 1 , indexS2, indexS3 + 1); 
        
        if(s1Plus)
            return true;

        if(indexS2 < s2.length && s2[indexS2] == s3[indexS3])
            s2Plus = traverse(s1, s2, s3, indexS1, indexS2 + 1, indexS3 + 1);

        return s1Plus || s2Plus;     
    
    }
}