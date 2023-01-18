import java.util.*;

class Trie {
    class Node {
        HashMap<Character, Node> childs;
        boolean isEnd;

        Node() {
            this.childs = new HashMap<>();
        }
    }

    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        int i = 0;
        for (i = 0; i < word.length(); i++) {
            if (!curr.childs.containsKey(word.charAt(i))) {
                curr.childs.put(word.charAt(i), new Node());
            }
            
            curr = curr.childs.get(word.charAt(i));
        }
         curr.isEnd = true;

        
        
    }

    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (!curr.childs.containsKey(word.charAt(i))) {
                return false;
            }
            
            curr = curr.childs.get(word.charAt(i));
        }
        // System.out.println("IN");

        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!curr.childs.containsKey(prefix.charAt(i))) {
                return false;
            }
            if (i == prefix.length() - 1) {
                break;
            }
            curr = curr.childs.get(prefix.charAt(i));
        }
        

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */