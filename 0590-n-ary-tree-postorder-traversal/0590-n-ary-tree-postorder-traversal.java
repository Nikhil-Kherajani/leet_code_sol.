/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    ArrayList<Integer> al = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        postOrder(root);
        return al;
    }
    public void postOrder(Node node){
        if(node == null){
            return;
        }
        for(Node n : node.children){
            postOrder(n);
        }
        al.add(node.val);
    }
}