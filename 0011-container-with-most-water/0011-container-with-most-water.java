import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public int maxArea(int[] height) {
        if (height.length == 1) {
            return 0;
        }
        int n = height.length;
        int start, end, area, maxArea = 0;
        start = 0;
        end = n-1;

        while (start < end) {
            area = (end - start) * Math.min(height[start], height[end]);
    
            maxArea = Math.max(area, maxArea);
            if (Math.min(height[start], height[end]) == height[start]) {
                start++;
            } else {
                end--;
            }

        }

        return maxArea;
    }
}