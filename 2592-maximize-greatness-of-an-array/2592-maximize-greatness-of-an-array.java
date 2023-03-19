class Solution {
    public int maximizeGreatness(int[] nums) {
        final int n = nums.length;
        int ans = 0;
        int[] copy = new int[n];
        Arrays.sort(nums);
        for(int i = 0 ; i < n ; i++){
            copy[i] = nums[i];
        }
        int c = 0;
        for(int i = 0 ; i < n ; i++){
            while(c < n && copy[c] != - 1 && copy[c] <= nums[i]){
                c++;
            }
            // System.out.println(i + " " + c);
            if(c >= n){
                break;
            }
            copy[c] = -1;
            c++;
            ans++;
        }
        return ans;
    }
}