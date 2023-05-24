class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i] = new int[] {nums1[i], nums2[i]};
        }
        
        Arrays.sort(pairs, (n1, n2) -> n2[1] - n1[1]);

        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        long ksum = 0;

        for (int i = 0; i < k; i++) {
            ksum += pairs[i][0];
            heap.add(pairs[i][0]);
        }

        long ans = ksum * pairs[k - 1][1];

        for (int i = k; i < n; i++) {
            ksum += pairs[i][0];
            ksum -= heap.poll();
            heap.add(pairs[i][0]);

            ans = Math.max(ans, ksum * pairs[i][1]);
        }

        return ans;
    }
}