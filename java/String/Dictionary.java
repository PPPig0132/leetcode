package String;
/*基于前缀树和DFS实现搜索 */
public class Dictionary {
    public static void main(String[] args) {
        
    }
}

class WordDictionary {

    // Trie 节点
    private static class TrieNode {
        TrieNode[] next = new TrieNode[26]; // 26 个小写字母
        boolean isWord = false;
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // 添加单词
    public void addWord(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (cur.next[idx] == null) {
                cur.next[idx] = new TrieNode();
            }
            cur = cur.next[idx];
        }
        cur.isWord = true;// 标记为单词结尾
    }

    // 支持 '.' 通配符的搜索
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int pos, TrieNode node) {
        if (pos == word.length()) {
            return node.isWord;
        }
        char ch = word.charAt(pos);
        if (ch == '.') {
            // 枚举 26 个分支
            for (TrieNode next : node.next) {
                if (next != null && dfs(word, pos + 1, next)) {
                    return true;
                }
            }
            return false;
        } else {
            int idx = ch - 'a';
            TrieNode next = node.next[idx];
            return next != null && dfs(word, pos + 1, next);
        }
    }
}