class Solution {
    public int countVowelPermutation(int n) {
        long count = 0, arr[][] = new long[n + 1][5];

        int mod = 1000000007;

        for (int i = 0; i < 5; i++) arr[1][i] = 1;
        for (int i = 2; i <= n; i++){
            arr[i][0] = (arr[i - 1][1] + arr[i - 1][2] + arr[i - 1][4]) % mod;
            arr[i][1] = (arr[i - 1][0] + arr[i - 1][2]) % mod;
            arr[i][2] = (arr[i - 1][1] + arr[i - 1][3]) % mod;
            arr[i][3] = (arr[i - 1][2]) % mod;
            arr[i][4] = (arr[i - 1][2] + arr[i - 1][3]) % mod;
        }
        for (long l : arr[n]){
            count += l;
            count %= mod;
        }
        return (int) count;
    }
}