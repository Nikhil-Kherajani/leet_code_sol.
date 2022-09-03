class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2); // sort nums2[] to avoid duplicates
        
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (i >= 1 && nums2[i] == nums2[i - 1]) {
                continue;
            }
            if (binarysearch(nums1, nums2[i]) == true) {
                res.add(nums2[i]);
            }
        }

        return res.stream().mapToInt(i -> i).toArray(); // arraylist of Integer to int[] array
    }
    private boolean binarysearch(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
}