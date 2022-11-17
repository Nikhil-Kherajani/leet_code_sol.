class Solution {
    public int sumOfFlooredPairs(int[] arr) {
        
    	int i,j,k,max,n=arr.length;
    	long sum=0,tot=0;
    	Arrays.sort(arr);
    	max=arr[n-1];
    	int count[]=new int[max+1];
    	for(i=0;i<n;i++)
    		count[arr[i]]++;
    	for(i=1;i<=max;i++)
    		count[i]+=count[i-1];
    	for(k=0;k<n;k++)
    	{
            if(k>0&&arr[k]-arr[k-1]==0)
                continue;
            i=arr[k];
    		for(j=2;j<=max/i+1;j++)
    		{
    			int lower=i*(j-1)-1;
    			int upper=i*(j)-1;
    			sum+=(count[Math.min(max, upper)]-count[lower])*(j-1);
    		}
    		tot+=sum*(count[i]-count[i-1]);
            sum=0;
    	}
        return (int)(tot%1000000007);
    }
}