class Solution {
    public int findKthPositive(int[] arr, int k) {
        for(int i : arr){
			if(i <= k) {
                System.out.println(i + " "  + k);
                k++;}
            else break;
		}
        return k;
    }
}