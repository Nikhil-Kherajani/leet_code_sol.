import java.util.*;



class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();

        Node temp = head;
        Node newList = new Node(temp.val);
        Node newListHead = newList;
        while (temp != null) {
            temp = temp.next;
            if (temp == null)
                break;
            Node newTemp = new Node(temp.val);
            newList.next = newTemp;
            newList = newList.next;
        }
        temp = head;
        Node tempnew = newListHead;

        while (temp != null) {
            map.put(temp, tempnew);
            temp = temp.next;
            tempnew = tempnew.next;
        }
        temp = head;
        tempnew = newListHead;

        while (temp != null) {
            if (temp.random == null) {
                tempnew.random = null;
            } else {
                tempnew.random = map.get(temp.random);
            }
            temp = temp.next;
            tempnew = tempnew.next;
        }

        return newListHead;
    }
}