class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] greater_elements = nextGreaterElementHelper(nums2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++){
            map.put(nums2[i], i);
        }
        int[] res = new int[nums1.length];
        for(int i = 0; i < res.length; i++){
            res[i] = greater_elements[map.get(nums1[i])];
        }
        return res;
    }
    private int[] nextGreaterElementHelper(int[] nums){
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
}