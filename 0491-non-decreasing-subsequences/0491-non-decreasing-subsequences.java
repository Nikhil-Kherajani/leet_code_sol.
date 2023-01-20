import java.util.*;

class Solution {

    private List<List<Integer>> ans = new ArrayList<List<Integer>>();
    private HashSet<List<Integer>> set = new HashSet<List<Integer>>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        Subsequences(new ArrayList<>(), -150, 0, nums);
        // System.out.println(set.toString());
        ans.addAll(set);
        return ans;
    }

    public void Subsequences(List<Integer> subsequence, int prev, int i, int[] nums) {
        // System.out.println(subsequence.toString());
        
        if (subsequence.size() > 1) {

            List<Integer> temp = new ArrayList<Integer>();
            temp.addAll(subsequence);
            set.add(temp);

            if (i >= nums.length) {
                return;
            }
        }
        if (i >= nums.length) {
            return;
        }
        boolean In = false;
        if (nums[i] >= prev) {
            subsequence.add(nums[i]);
            In = true;
            Subsequences(subsequence, nums[i], i + 1, nums);
        }
       
        if(In && subsequence.size() > 0)
        subsequence.remove(subsequence.size() - 1);

        Subsequences(subsequence, prev, i + 1, nums);

    }
}