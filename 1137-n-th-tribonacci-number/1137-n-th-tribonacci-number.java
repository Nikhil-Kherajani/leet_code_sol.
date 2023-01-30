class Solution {
    public int tribonacci(int n) {
        int t0 = 0, t1 = 1, t2 = 1;
        for (int i = 3;i <= n; i++) {
            if (i % 3 == 0) {
                t0 = t0 + t1 + t2;
            } else if (i % 3 == 1) {
                t1 = t0 + t1 + t2;
            } else {
                t2 = t0 + t1 + t2;
            }
        }
        return n % 3 == 0 ? t0 : n % 3 == 1 ? t1 : t2;

    }
}