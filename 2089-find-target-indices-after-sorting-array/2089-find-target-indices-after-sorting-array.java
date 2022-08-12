class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> indexs=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target)indexs.add(i);
        }
    return indexs;
    }
}