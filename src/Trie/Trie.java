package Trie;

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
        System.out.println("Created Trie Object Successfully.");

    }

    //case 1: A trie is blank (APP)
    //case 2: if new string's prefix is common to another string's prefix (API)
    //case 3: New String prefix is already present as complete string (APIS)
    //case 4: Insert already present string(APIS)-> no need to insert again
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode temp = current.children.get(ch);
            if (temp == null) {
                temp = new TrieNode();
                current.children.put(ch, temp);
            }
            current = temp;
        }
        current.isEndOfString = true;
        System.out.println("word " + word + " inserted successfully.");
    }

    public boolean search(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode temp = current.children.get(ch);
            if (temp == null) {
                System.out.println("Word:" + word + " doesn not exist in trie.");
                return false;
            }
            current = temp;
        }
        if (current.isEndOfString) {
            System.out.println("Word:" + word + " exist in trie.");
        } else {
            System.out.println("Word:" + word + " does not exist in trie. But its prefix of another String");
        }
        return current.isEndOfString;
    }

    public void delete(String word) {
        if (this.search(word)) {
            delete(root, word, 0);
        }
    }

    //case 1 app,apple
    //case 2
    private boolean delete(TrieNode parentNode, String word, int index) {
        char ch = word.charAt(index);
        TrieNode currentNode = parentNode.children.get(ch);
        boolean canThisNodeDeleted;
        //common prefix
        if (currentNode.children.size() > 1) {
            delete(currentNode, word, index + 1);
            return false;
        }

        //API, APIS
        if (word.length() - 1 == index) {
            if (currentNode.children.size() > 0) {
                currentNode.isEndOfString = false;
                return false;
            } else {
                parentNode.children.remove(ch);
                return true;
            }
        }

        //APIS, AP
        if (currentNode.isEndOfString) {
            delete(currentNode, word, index + 1);
            return false;
        }

        //not any node depends on k.
        canThisNodeDeleted = delete(currentNode, word, index + 1);
        if (canThisNodeDeleted) {
            parentNode.children.remove(ch);
            return true;
        } else {
            return false;
        }
    }

//    private boolean deleteMy(TrieNode currentNode, String word, int index) {
//        if (currentNode == null)
//            return false;
//
//        char ch = word.charAt(index);
//        TrieNode childrenNode = currentNode.children.get(ch);
//        if (word.length() - 1 == index) {
//            if (childrenNode.children.size() > 0) {
//                childrenNode.isEndOfString = false;
//                return false;
//            } else {
//                currentNode.children.remove(ch);
//                return true;
//            }
//        }
//
//
//
//    }
}



