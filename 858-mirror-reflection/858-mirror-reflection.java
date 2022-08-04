class Solution {
    public int mirrorReflection(int p, int q) {
        while(((p|q)&1) == 0){
            p >>= 1;
            q >>= 1;
        }
        return (q&1) + ((p&1)^1);
    }
}