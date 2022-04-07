package Trie;

public class TrieTest {
    public static void main(String argp[]) {

        Trie trie = new Trie();
        trie.insert("APP");
        trie.insert("API");
        trie.insert("APIS");
        trie.search("APP");
        trie.search("API");
        trie.search("APIS");
        trie.search("AP");
        trie.search("ABIS");

        trie.delete("ABIS");
        trie.delete("APP");
        trie.search("APP");
    }


}
