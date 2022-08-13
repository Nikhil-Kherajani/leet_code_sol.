class Solution {
    public boolean isPowerOfTwo(int n) {
        while(true){
        if(n==1){
            return true;
        }
        if(n%2!=0 || n<=0){
            return false;
        }
        return isPowerOfTwo(n/2);
    }
    }
}
