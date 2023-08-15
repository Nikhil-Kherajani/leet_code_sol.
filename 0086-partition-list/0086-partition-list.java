class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallLinkList=new ListNode(1);
        ListNode largeLinkList=new ListNode(1);
        ListNode temp1=smallLinkList;
        ListNode temp2=largeLinkList;
        while(head!=null){
            if(head.val<x){
                temp1.next=head;
                temp1=temp1.next;
            }
            else{
                temp2.next=head;
                temp2=temp2.next;
            }
            head=head.next;
        }
        temp1.next=largeLinkList.next;
        temp2.next=null;
        return smallLinkList.next;
    }
}