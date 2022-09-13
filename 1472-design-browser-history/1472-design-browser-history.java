class ListNode {
    String page;
    ListNode next;
    ListNode prev;
    ListNode(String page) { this.page = page; }
}


class BrowserHistory {

    ListNode head;
    
    public BrowserHistory(String homepage) {
        head = new ListNode(homepage);
        head.prev = null;
    }
    
    public void visit(String url) {
        ListNode prev = head;
        head.next = new ListNode(url);
        head = head.next;
        head.prev = prev;
    }
    
    public String back(int steps) {
        while(steps-- > 0 && head.prev != null) head = head.prev;
        
        return head.page;
    }
    
    public String forward(int steps) {
        while(steps-- > 0 && head.next != null) head = head.next;
        
        return head.page;
    }
}