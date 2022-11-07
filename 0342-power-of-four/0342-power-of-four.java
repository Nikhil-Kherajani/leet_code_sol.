class Solution {
    public boolean isPowerOfFour(int n) {
        float temp = n;
        while (temp > 1) {
            temp = temp / 4;
        }
        if (temp == 1) {
            return true;
        }
        return false;
    }
}