class Solution {
    public int getMaximumGenerated(int n) {
        if(n==0)return 0;
        if(n==1)return 1;
        int []arr=new int[n+1];
        arr[0]=0;
        arr[1]=1;
        int maxi=Integer.MIN_VALUE;
        for(int i=2;i<=n;i++){
            if(i%2==0)arr[i]=arr[i/2];
            else arr[i]=arr[i/2]+arr[(i/2)+1];
            maxi=Math.max(maxi,arr[i]);
        }
        return maxi;
    }
}