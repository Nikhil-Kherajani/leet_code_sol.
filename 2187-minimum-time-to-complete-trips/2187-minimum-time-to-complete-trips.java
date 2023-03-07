class Solution {
    public long min(int[] time){
        long minv = Long.MAX_VALUE ;
        for(long val : time){
            if(val < minv){
                minv = val;
            }
        }
        return minv;
    }
    public long minimumTime(int[] time, int totalTrips) {
        long low=min(time)*totalTrips;
        long high=0;
        long min=Long.MAX_VALUE;
        for(int it:time){
            low=Math.min(low,it);
            min=Math.min(min,it);
        }
        high=totalTrips*min;
        while(low<high){
            long mid=low+(high-low)/2;
            if(blackbox(mid,totalTrips,time)){
                high=mid;
            }
            else
                low=mid+1;
        }
        return low;
    }
    public boolean blackbox(long isvalidtime,int totalTrips,int[] time){
        long trips=0;
        for(int it:time){
            trips+=isvalidtime/it;
        }
        if(trips>=totalTrips)
            return true;
        return false;
    }
}