class Solution {
    public int kthGrammar(int n, int k) {
        int count = Integer.bitCount(k - 1);
        return count % 2 == 0 ? 0 : 1;
    }
}