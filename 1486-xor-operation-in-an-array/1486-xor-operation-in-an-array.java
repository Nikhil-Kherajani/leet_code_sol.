class Solution {
public int xorOperation(int n, int start) {

    int[] ans = new int[n];
    
    ans[0] = start;
    
    int check = start;
    
    for(int i=1; i<ans.length; i++)
    {
        ans[i] = start + 2*i;
        check = check ^ ans[i];            
    }
    
    return check;
}
}