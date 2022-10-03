class Solution {
    public boolean containsNearbyDuplicate(int[] arr, int k) {
        if(arr.length==1){
            return false;
        }
        Map<Integer,Integer>a=new HashMap<Integer,Integer>();
        int n=0;
        boolean flag=false;
        for(int i=0;i<arr.length;i++)
        {
            if(a.containsKey(arr[i]))
            {
                n=(Math.abs(a.get(arr[i])-i));
                if(n<=k){
                   flag=true;
                    break;
                }
                else{
                    flag=false;
                }
                a.put(arr[i],i);
            }
            
            else
            {
                a.put(arr[i],i);
            }
        }
        
        return flag;
    }
}