import java.util.*;

class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0, numToBeSubs = 0, ns = 0, total = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                count++;
            } else if (nums[i] < left) {
                boolean in = false;
                int babycount = 1;
                while (i+1 < nums.length && nums[i+1]<left) {
                    in = true;
                    i++;
                    babycount++;
                    count++;
                }
                
                if (!in) {
                    count++;
                    numToBeSubs++;
                } else {
                    // if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                    //     babycount++;
                    // }
                    // if (i == nums.length - 1)
                    
                        count++;
                    if (babycount % 2 == 0) {
                        numToBeSubs += (babycount / 2) * (babycount + 1);
                    } else
                        numToBeSubs += babycount * ((babycount + 1) / 2);
                }
            }
            if (nums[i] > right || i == nums.length - 1) {
                if (count % 2 == 0) {
                    ns = (count / 2) * (count + 1);
                } else
                    ns = count * ((count + 1) / 2);
                ns -= numToBeSubs;
                total += ns;
                count = 0;
                numToBeSubs = 0;
                ns = 0;
            }

        }
        return total;

    }
}