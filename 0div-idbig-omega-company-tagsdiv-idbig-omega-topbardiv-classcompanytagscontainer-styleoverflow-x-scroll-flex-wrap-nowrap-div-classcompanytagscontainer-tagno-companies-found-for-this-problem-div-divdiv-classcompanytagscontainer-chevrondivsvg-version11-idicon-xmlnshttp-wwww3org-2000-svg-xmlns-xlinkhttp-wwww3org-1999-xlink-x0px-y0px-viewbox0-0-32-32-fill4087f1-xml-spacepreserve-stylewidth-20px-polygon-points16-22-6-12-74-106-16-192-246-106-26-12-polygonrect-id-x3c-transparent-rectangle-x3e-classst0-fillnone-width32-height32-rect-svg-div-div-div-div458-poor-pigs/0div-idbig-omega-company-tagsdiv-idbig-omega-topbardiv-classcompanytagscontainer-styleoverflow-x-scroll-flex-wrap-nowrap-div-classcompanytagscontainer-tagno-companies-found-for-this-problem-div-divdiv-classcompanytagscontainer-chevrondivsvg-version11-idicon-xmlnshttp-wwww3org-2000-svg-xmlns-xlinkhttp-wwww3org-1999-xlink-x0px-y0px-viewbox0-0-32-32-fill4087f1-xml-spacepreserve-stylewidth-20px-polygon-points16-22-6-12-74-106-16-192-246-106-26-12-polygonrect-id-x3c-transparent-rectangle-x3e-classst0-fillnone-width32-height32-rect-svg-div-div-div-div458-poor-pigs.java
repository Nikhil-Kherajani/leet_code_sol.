class Solution {
    public int poorPigs(int b, int m, int n) {
        int c=0;
        while(Math.pow(n/m+1,c)<b)
        {
            c++;
        }
        return c;
    }
}