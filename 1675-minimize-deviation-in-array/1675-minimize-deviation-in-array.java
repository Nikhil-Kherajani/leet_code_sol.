class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int min = Integer.MAX_VALUE;
        for(int num : nums) {
            if (isEven(num)) heap.add(num);
            else {
                num*=2;
                heap.add(num);
            }
            min = Math.min(min, num);
        }
        
        int max = heap.poll();
        int result = max-min;
        
        while (!finished(min, max, result)) {
            heap.add(max/2);
            min = Math.min(min, max/2);
            max = heap.poll();
            result = Math.min(result, max-min);
        }
        
        return result;
    }
    
    private boolean finished(int min, int max, int result) {
        return result == 0 || isOdd(max);
    }
    
    private boolean isEven(int num) {
        return num % 2 == 0;
    }
    
    private boolean isOdd(int num) {
        return num % 2 != 0;
    }
}