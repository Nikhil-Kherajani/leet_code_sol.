class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }
        
        int ans = 0;
        for(Integer i : map.values())
        {
            ans += ((i)*(i-1))/2;
        }
        return ans;
    }
}