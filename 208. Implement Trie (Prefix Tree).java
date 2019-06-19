class Trie {

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            if (node.characterMap.containsKey(c)) {
                node = node.characterMap.get(c);
            } else {
                node.characterMap.put(c, new TrieNode());
                node = node.characterMap.get(c);
            }
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            if (node.characterMap.containsKey(c)) {
                node = node.characterMap.get(c);
            } else {
                return false;
            }
        }
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c: prefix.toCharArray()) {
            if (node.characterMap.containsKey(c)) {
                node = node.characterMap.get(c);
            } else {
                return false;
            }
        }
        return true;
    }

    class TrieNode {

        Map<Character, TrieNode> characterMap;
        boolean isWord;

        public TrieNode() {
            characterMap = new HashMap<>();
            isWord = false;
        }
    }
}
