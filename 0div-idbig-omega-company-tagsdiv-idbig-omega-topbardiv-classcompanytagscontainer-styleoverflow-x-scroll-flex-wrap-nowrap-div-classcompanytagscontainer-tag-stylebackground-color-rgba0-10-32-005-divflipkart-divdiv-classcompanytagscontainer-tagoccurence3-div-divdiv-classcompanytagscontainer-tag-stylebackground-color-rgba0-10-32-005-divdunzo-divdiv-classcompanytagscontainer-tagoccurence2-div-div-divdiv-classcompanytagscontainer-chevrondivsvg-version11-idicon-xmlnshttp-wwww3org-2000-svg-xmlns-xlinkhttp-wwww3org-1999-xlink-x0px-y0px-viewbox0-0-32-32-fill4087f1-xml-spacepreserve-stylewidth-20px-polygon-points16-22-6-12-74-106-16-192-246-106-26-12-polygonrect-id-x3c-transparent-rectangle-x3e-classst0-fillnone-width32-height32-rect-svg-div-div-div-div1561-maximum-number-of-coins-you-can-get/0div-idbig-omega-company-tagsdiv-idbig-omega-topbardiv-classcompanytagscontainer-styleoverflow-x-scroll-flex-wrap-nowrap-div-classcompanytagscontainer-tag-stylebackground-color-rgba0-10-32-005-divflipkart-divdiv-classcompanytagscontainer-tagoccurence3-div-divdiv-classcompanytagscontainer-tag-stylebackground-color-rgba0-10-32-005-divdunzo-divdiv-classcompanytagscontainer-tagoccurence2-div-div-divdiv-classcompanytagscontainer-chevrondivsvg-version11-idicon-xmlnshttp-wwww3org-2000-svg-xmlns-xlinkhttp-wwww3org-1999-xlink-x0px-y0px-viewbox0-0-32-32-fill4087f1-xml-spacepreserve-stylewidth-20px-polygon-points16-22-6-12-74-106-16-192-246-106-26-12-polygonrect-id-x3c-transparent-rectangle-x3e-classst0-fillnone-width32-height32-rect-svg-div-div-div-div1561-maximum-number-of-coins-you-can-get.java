class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        ArrayDeque<Integer> queue = new ArrayDeque();
        for (int num : piles) {
            queue.addLast(num);
        }
        
        int ans = 0;
        while (!queue.isEmpty()) {
            queue.removeLast();
            ans += queue.removeLast(); 
            queue.removeFirst();
        }
        
        return ans;
    }
}