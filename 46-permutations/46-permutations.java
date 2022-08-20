class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        allPermute(nums,nums.length,new int[nums.length ],new ArrayList<>() , ans);
        return ans ;
    }
    
    public void allPermute(int nums[], int n , int[] visited ,List<Integer> num , List<List<Integer>> ans){
        if(n == 0){
            // System.out.println(num);
            ans.add(new ArrayList<>(num));
            return;
        }
        
        for(int i = 0; i< nums.length;i++){
            if(visited[i] == 0){
                num.add(nums[i]);
                visited[i] = 1;
                allPermute(nums, n - 1 , visited,num , ans);
                num.remove(num.size()-1);
                visited[i] = 0;
                
            }
        }
        
    }
    
}