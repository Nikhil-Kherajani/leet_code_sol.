class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            list.add(index[i],nums[i]);
        int arr[] = new int[list.size()];
        for(int j=0;j<arr.length;j++)
            arr[j]=list.get(j);
        return arr;
    }
}