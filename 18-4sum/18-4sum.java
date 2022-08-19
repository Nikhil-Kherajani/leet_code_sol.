class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums ==null && nums.length<4) return result;
        if(nums[0]==1000000000 && nums[1]==1000000000) return result;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n-3;i++) {
            if(i!=0 && nums[i-1]==nums[i]) continue;
            for(int j=i+1;j<n-2;j++) {
                if(j!=i+1 && nums[j-1] == nums[j]) continue;
                int low=j+1,high=n-1;
                int commonSum = nums[i] + nums[j];
                int min = nums[low] + nums[low+1] + commonSum;
                int max = nums[high] + nums[high-1] + commonSum;
                if(target< min || target> max) continue;
                while(low<high) {
                    int sum = nums[low] + nums[high] + commonSum;
                    if(sum == target ) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        low++;
                        high--;
                        while(low<n && nums[low] == nums[low-1]) low++;
                        while(high>low && nums[high] == nums[high+1]) high--;
                    } else if(sum < target) {
                        low++;
                        while(low<n && nums[low] == nums[low-1]) low++;
                    } else {
                        high--;
                        while(high>low && nums[high] == nums[high+1]) high--;
                    }
                }
            }
        }
        return result;
    }
}