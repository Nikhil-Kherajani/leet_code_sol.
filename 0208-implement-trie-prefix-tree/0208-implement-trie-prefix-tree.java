class TrieNode {
boolean isEnd;
TrieNode[] children;

public TrieNode() {
    isEnd = true;
    children = new TrieNode[26];
}
}

public class Trie {
private TrieNode root;

public Trie() {
    root = new TrieNode();
}

public void insert(String word) {
	TrieNode current = root;
	for(int i=0, L=word.length(); i<L; i++) {
    	int id = word.charAt(i) - 'a';
    	if(current.children[id]==null) {
    		current.children[id] = new TrieNode();
    		current.children[id].isEnd = false;
    	}
    	current = current.children[id];
    }
    current.isEnd = true;
}

public boolean search(String word) {
    return search(word, 1);
}
public boolean startsWith(String prefix) {
    return search(prefix, 2);
}
private boolean search(String str, int type) {
    TrieNode current = root;
    int i=-1, L=str.length();
    while(++i<L) {
        int id = str.charAt(i) - 'a';
        if((current=current.children[id]) == null) return false;
    }
    return type==1 ? current.isEnd : true;
}
}