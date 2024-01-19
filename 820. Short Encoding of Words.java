class Solution {
    TrieNode root;
    class TrieNode {
        TrieNode[] next = null;
    }
    public int minimumLengthEncoding(String[] words) {
        root = new TrieNode();
        root.next = new TrieNode[26];
        int res = 0;
        for (String w : words) {
            res += helper(w);
        }
        return res;
    }
    public int helper(String w) {
        int length = w.length();
        boolean newBranch = false;
        int create = 0;
        TrieNode current = root;
        for (int i = length - 1; i >= 0; --i) {
            boolean newLevel = false;
            int id = w.charAt(i) - 'a';
            if (current.next == null) {
                newLevel = true;
                current.next = new TrieNode[26];
            }
            if (current.next[id] == null) {
                if (!newLevel) newBranch = true;
                current.next[id] = new TrieNode();
                create++;
            }
            current = current.next[id];
        }
        return newBranch ? length + 1 : create;
    }
}
