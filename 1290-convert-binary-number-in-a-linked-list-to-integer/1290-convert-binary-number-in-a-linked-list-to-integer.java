class Solution {
    public int getDecimalValue(ListNode head) {     
        int ans = 0;
        for(ListNode temp =  head;temp!=null;temp=temp.next){
            ans =  (ans<<1)+temp.val;
        }                
        return ans;        
    }
}