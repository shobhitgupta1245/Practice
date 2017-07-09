/**
 * Created by shobhit on 12/06/17.
 */
public class Trie {

    private TrieNode root;

    public TrieNode getRoot() {
        return root;
    }

    public void setRoot(TrieNode root) {
        this.root = root;
    }

    public void insert(String word) {
        if (root == null) {
            root = new TrieNode();
        }
        TrieNode tmp = root;
        for (int i = 0; i < word.length(); i++) {
            if (tmp.trieNodes[word.charAt(i) - 'a'] == null) {
                tmp.trieNodes[word.charAt(i) - 'a'] = new TrieNode();
            }
            tmp = tmp.trieNodes[word.charAt(i) - 'a'];
        }
        tmp.isLeafNode = true;
    }

    public void search(String word) {
        int i;
        if (root == null) {
            System.out.println("Empty Trie");
        }
        TrieNode tmp = root;
        for (i = 0; i < word.length(); i++) {
            if (tmp.trieNodes[word.charAt(i) - 'a'] != null) {
                tmp = tmp.trieNodes[word.charAt(i) - 'a'];
            }
            else {
                System.out.println("Word[" + word + "] not found");
                break;
            }
        }
        if (i == word.length()) {
            System.out.println("Word[" + word + "] found");
        }
    }

    private static void traverse(TrieNode t, String word) {
        for (int i = 0; i < 26; i++) {
            if (t.trieNodes[i] != null) {
                traverse(t.trieNodes[i], word + Character.toString((char)('a' + i)));
            }
            if (t.isLeafNode) {
                System.out.println(word);
                break;
            }
        }
    }

    public static void traverse(Trie t) {
        traverse(t.getRoot(), "");
    }

    public static class TrieNode {
        private boolean isLeafNode;
        private TrieNode[] trieNodes = new TrieNode[26];

        public boolean isLeafNode() {
            return isLeafNode;
        }

        public void setLeafNode(boolean leafNode) {
            isLeafNode = leafNode;
        }

        public TrieNode[] getTrieNodes() {
            return trieNodes;
        }

        public void setTrieNodes(TrieNode[] trieNodes) {
            this.trieNodes = trieNodes;
        }
    }

}