class Solution {
    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> res = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            res.put(nums[i], res.getOrDefault(nums[i],0) + 1);
        }
        int d = 0;
        int m = 0;
        for(int i = 1; i < nums.length + 1; i++){
            if(res.getOrDefault(i, 0) == 2){
                d = i;
            }else if(res.getOrDefault(i, 0) == 0){
                m = i;
            }
        }

        return new int[]{d,m};
    }
}