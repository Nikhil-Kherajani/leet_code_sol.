import java.util.*;

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] num = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            num[i][0] = nums1[i];
            num[i][1] = nums2[i];
        }

        Arrays.sort(num,
                (a, b) -> Integer.compare(a[1], b[1]) == 0 ? Integer.compare(b[0], a[0]) : Integer.compare(a[1], b[1]));
        int l = 0;
        int r = num.length - 1;
        while (l < r) {
            int temp0 = num[l][0];
            int temp1 = num[l][1];
            num[l][0] = num[r][0];
            num[l][1] = num[r][1];
            num[r][0] = temp0;
            num[r][1] = temp1;
            l++;
            r--;
        }
        // for (int i = 0; i < num.length; i++) {
        //     System.out.println(num[i][0] + " " + num[i][1]);
        // }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        long sum = 0;
        long maxSum = -1;
        for (int i = 0; i < k - 1; i++) {
            pq.add(num[i][0]);
            sum += num[i][0];
        }

        for (int i = k - 1; i < num.length; i++) {
            // System.out.println(i + " " + pq.size());
            if (pq.size() < k) {
                pq.add(num[i][0]);
                sum += num[i][0];
            } else {
                if (num[i][0] > pq.peek()) {
                    sum -= pq.poll();
                    pq.add(num[i][0]);
                    sum += num[i][0];
                }

            }

            maxSum = Math.max(maxSum, sum * num[i][1]);

        }
        return maxSum;

    }
}