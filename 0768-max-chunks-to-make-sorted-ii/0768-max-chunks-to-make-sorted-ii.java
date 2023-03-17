class Solution {
    public int maxChunksToSorted(int[] arr) {
        final int n = arr.length;
        int ans = 0, last = n - 1 ;

        for(int i = n - 1 ;i >= 0 ; i--){
            // System.out.println("i = " + i);

            int temp = i;
            for(int j = i - 1 ; j >=0 ; j--){
                if(arr[j] > arr[temp]){
                    i = j;
                    // System.out.println("j = " + j);
                }
            }
            last = temp - 1;
            for(; last >= i ; last --){
                for(int k = last - 1 ; k >= 0 ; k--){
                    if(arr[k] > arr[last]){
                        i = Math.min(k,i);
                        // System.out.println("j = " + j);
                    }
                }
            }
            ans++;
        }
        return ans;
    }
}