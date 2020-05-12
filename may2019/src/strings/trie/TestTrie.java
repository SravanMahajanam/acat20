package strings.trie;

public class TestTrie {
    public static void main(String[] args) {
        ITrie trie = new TernaryTrie();
        trie.add("pqr");
        trie.add("abc");
        trie.add("ab");
        trie.add("abcd");
        trie.add("axy");
        trie.add("xyz");
        trie.add("xab");
        System.out.println(trie.autoComplete(""));
        System.out.println(trie.autoComplete("a"));
        System.out.println(trie.autoComplete("ab"));
        System.out.println(trie.lcp("axyb"));
        //System.out.println(trie.contains("axyb"));
        //System.out.println(trie.contains("axy"));
    }
}
