package leetcode;

public class Trie {

	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public Trie(String word) {
		root = new TrieNode();
		addWord(word);
	}

	public void addWord(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.links[c - 'a'] == null) {
				cur.links[c - 'a'] = new TrieNode();
			}
			cur = cur.links[c - 'a'];
		}
	}

	public boolean findWord(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.links[c - 'a'] == null) {
				return false;
			}
			cur = cur.links[c - 'a'];
		}
		return true;
	}

}

class TrieNode {
	TrieNode[] links;

	public TrieNode() {
		links = new TrieNode[26];
	}
}

/**
 * 
 * 2 lists,
 * 
 * take k elements from list
 * 
 * keep only the
 * 
 */