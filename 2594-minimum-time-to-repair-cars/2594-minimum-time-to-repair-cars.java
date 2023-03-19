 class Solution {
     // vs : y , c : n
     public long repairCars(int[] A, int cars) {
        long left = 1, right = 1L * A[0] * cars * cars;
        while (left < right) {
            long mid = (left + right) / 2, cur = 0;
            for (int a : A)
                cur += (long)(Math.sqrt(1.0 * mid / a));
            if (cur < cars)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
 }