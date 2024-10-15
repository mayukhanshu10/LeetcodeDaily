class Node {
    char data;
    Node[] child;
    boolean isEnd;

    Node() {
        child = new Node[26];
        isEnd = false;
    }

    Node(char c) {
        this.data = c;
        child = new Node[26];
        isEnd = false;
    }
}

class WordDictionary {
    Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    // Add word to the trie
    public void addWord(String word) {
        int len = word.length();
        Node curr = root;
        for (int i = 0; i < len; i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.child[idx] == null) {
                curr.child[idx] = new Node(word.charAt(i));
            }
            curr = curr.child[idx];
        }
        curr.isEnd = true;
    }

    // Search word with support for '.' wildcard
    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }

    // Helper function for recursive search
    private boolean searchInNode(String word, int index, Node node) {
        if (node == null) return false;  // No match found
        if (index == word.length()) return node.isEnd;  // End of word, check if it's valid

        char ch = word.charAt(index);

        // Case 1: If character is '.', try all possible children
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.child[i] != null) {
                    // Recurse for all child nodes
                    if (searchInNode(word, index + 1, node.child[i])) {
                        return true;
                    }
                }
            }
            return false;  // No valid paths found
        }
        // Case 2: Regular character, move to the corresponding child node
        else {
            int idx = ch - 'a';
            return searchInNode(word, index + 1, node.child[idx]);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
