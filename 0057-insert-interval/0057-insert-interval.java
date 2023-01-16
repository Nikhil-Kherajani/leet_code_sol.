class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();
        int[] merged = new int[] {newInterval[0], newInterval[1]};
        boolean isInserted = false;

        for (int[] interval : intervals) {
            if(interval[0] > merged[1]) {
                if(!isInserted) {
                    mergedIntervals.add(merged);
                    isInserted = true;
                }
                mergedIntervals.add(interval);
                
            } else {
                // does intersect
                if(doesIntersect(merged, interval)) {
                    merged[0] = Math.min(merged[0], interval[0]);
                    merged[1] = Math.max(merged[1], interval[1]);
                } else {
                    // not intersecting
                    mergedIntervals.add(interval);
                }
                
                
            }
        }

        // new interval is at the end
        if(!isInserted) {
            mergedIntervals.add(merged);
            isInserted = true;
        }

        // Java specific to copy to arr[][]...
        int[][] res = new int[mergedIntervals.size()][2];
        for(int i = 0; i < mergedIntervals.size(); i++) {
            res[i] = mergedIntervals.get(i);
        }
        return res;

    }

    private boolean doesIntersect(int[] intervalA, int[] intervalB) {
        return intervalA[0] <= intervalB[1] && intervalB[0] <= intervalA[1];
    }
}