
class Solution {
    private int[][] t;
    private int solve(int[] newCuts, int l, int r){
        if(r-l < 2)
            return 0;
        if(t[l][r] != -1)
            return t[l][r];
        
        int mini=Integer.MAX_VALUE;
        for(int i=l+1; i<r; i++){
            int cost=(newCuts[r]-newCuts[l]) + solve(newCuts,l,i) + solve(newCuts,i,r);
            mini = Math.min(mini,cost);
        }
        return t[l][r] = mini;
    }
        
    public int minCost(int n, int[] cuts) {
        this.t = new int[103][103];
        for(int[] tt: t){
            Arrays.fill(tt,-1);
        }
        Arrays.sort(cuts);
        int m=cuts.length;
        int[] newCuts = new int[m+2];
        newCuts[0]=0;//starting point of stick
        newCuts[m+1]=n;//ending point of stick
        for(int i=1; i<m+1; i++){
            newCuts[i]=cuts[i-1];
        }
        //length of stick =  newCuts[r]-newCuts[l]
        return solve(newCuts,0,newCuts.length-1);
    }
}