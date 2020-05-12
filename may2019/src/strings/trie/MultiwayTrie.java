package strings.trie;

import java.util.LinkedList;
import java.util.List;

public class MultiwayTrie implements ITrie {
    MultiWayNode root;
    MultiwayTrie() {
            root = new MultiWayNode();
    }

    @Override
    public void add(String string) {
        MultiWayNode current = root;
        for (int i =0; i<string.length();++i) {
            if (current.children[string.charAt(i) - 'a'] == null) {
                current.children[string.charAt(i) - 'a'] = new MultiWayNode();
            }
            current = current.children[string.charAt(i) - 'a'];
        }
        current.isWord = true;
    }

    @Override
    public boolean contains(String string) {
        MultiWayNode current = root;
        for (int i = 0;i<string.length();++i) {
            if (current.children[string.charAt(i) - 'a'] ==  null) {
                return false;
            }
            current = current.children[string.charAt(i) - 'a'];
        }
        return current.isWord;
    }

    @Override
    public void remove(String string) {
        if (contains(string)){
            MultiWayNode current = root;

        }
    }

    @Override
    public String lcp(String string) {
        MultiWayNode current = root;
        int i;
        for (i = 0; i<string.length();++i) {
            if (current.children[string.indexOf(i) - 'a'] == null) {
                break;
            }
            current = current.children[string.indexOf(i) - 'a'];
        }
        return string.substring(0, i);
    }

    @Override
    public List<String> autoComplete(String string) {

        MultiWayNode temp = findLastNode(string);
        if (temp == null) {
            return null;
        }
        List<String> list = new LinkedList<String>();
        traverse(temp, string, list);

        return list;
    }

    private MultiWayNode findLastNode(String prefix) {
        MultiWayNode current = root;
        for (int i =0; i<prefix.length();++i) {
            if (current.children[prefix.charAt(i) - 'a'] == null) {
                return null;
            }
            current = current.children[prefix.charAt(i) - 'a'];
        }
        return current;
    }

    private void traverse(MultiWayNode current, String prefix, List<String> list) {
        if (current == null) {
            return;
        }
        if (current.isWord) {
            list.add(prefix);
        }
        for (int i =0; i<26;++i) {
            traverse(current.children[i],prefix + (char) ('a' + i), list);
        }
    }
}

class MultiWayNode {
    boolean isWord;
    MultiWayNode[] children;

    MultiWayNode() {
        isWord = false;
        children = new MultiWayNode[26];
    }
}
