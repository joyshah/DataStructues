package Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
     Map<Character, TrieNode> children;
     boolean isEndOfString;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isEndOfString = false;
    }
}
