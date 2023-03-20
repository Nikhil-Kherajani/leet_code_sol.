import java.util.*;

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int ans = 0;
        int[] freq = new int[value];
        for (int val : nums) {
            if(val < 0){
                // if(val * -1 < value){
                //     val = val + value;   
                // }
                // else
                //     val = val * (-1); d
                val = (val% value) + value;
                
            }
            freq[val % value]++;
        }
        int min = Integer.MAX_VALUE;
        int minf = Integer.MAX_VALUE;

        for (int i = 0; i < freq.length; i++) {
            if (minf > freq[i]) {
                min = i;
                minf = freq[i];
            }
            // min = Math.min(freq[i] , min);
        }
        return (value * minf + min);
    }
}