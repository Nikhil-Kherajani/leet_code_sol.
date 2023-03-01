import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        final int n = arr.length;
        int ei = Arrays.binarySearch(arr, x);
        int l;
        int r;
        if (ei < 0) {
            ei = ei * -1 - 1;
            l = ei - 1;
            r = ei;
        } else {
            ans.add(arr[ei]);
            k--;
            l = ei - 1;
            r = ei + 1;
        }

        while (k > 0 && l >= 0 && r < n) {

            if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                ans.add(arr[l]);
                l--;
            } else {

                ans.add(arr[r]);
                r++;
            }
            k--;
        }
        while (k > 0 && l >= 0) {
            ans.add(arr[l]);
            l--;
            k--;
        }
        while (k > 0 && r < n) {
            ans.add(arr[r]);
            r++;
            k--;
        }
        Collections.sort(ans);

        return ans;
    }
}