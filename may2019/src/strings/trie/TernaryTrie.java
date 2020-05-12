package strings.trie;

import java.util.ArrayList;
import java.util.List;

public class TernaryTrie implements ITrie {

    private TernaryNode root;

    @Override
    public void add(String string) {
        TernaryNode temp = auxAdd(root, string);
        if (root == null) {
            root = temp;
        }

    }

    private TernaryNode auxAdd(TernaryNode current, String string) {
        if (current == null) {
            current = new TernaryNode(string.charAt(0));
        }
        if (current.data == string.charAt(0)) {
            if (string.length() == 1) {
                current.isWord = true;
                return current;
            }
            current.middle = auxAdd(current.middle, string.substring(1));
        } else if (current.data > string.charAt(0)) {
            current.left = auxAdd(current.left, string);
        } else {
            current.right = auxAdd(current.right, string);
        }
        return current;
    }

    @Override
    public boolean contains(String string) {
        return false;
    }

    @Override
    public void remove(String string) {

    }

    public String lcp(String string) {
        int lcpPos = auxLcp(string);
        return string.substring(0,lcpPos+1);
    }

    private int auxLcp(String string) {
        TernaryNode current = root;
        int i = 0;
        while (current != null && i < string.length()) {
            if (current.data == string.charAt(0)) {
                ++i;
                current = current.middle;
                string = string.substring(1, string.length());

            } else if (current.data > string.charAt(0)) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return i;

    }

    @Override
    public List<String> autoComplete(String prefix) {
        List<String> completeWords = new ArrayList<String>();
        if (prefix.length() == 0) {
            traverse(root, prefix, completeWords);
        } else {
            TernaryNode temp = findLastNode(root, prefix);
            if (temp == null) {
                return null;
            }
            if (temp.isWord) {
                completeWords.add(prefix);
            }
            traverse(temp.middle, prefix, completeWords);

        }
        return completeWords;
    }

    private TernaryNode findLastNode(TernaryNode current, String prefix) {

        if (current == null) {
            return null;
        }
        int i = 0;
        while (i < prefix.length()) {
            if (prefix.charAt(0) == current.data) {
                //go middle,
                // but if prefix is only one char then we should not go to middle as match is at current node
                // and this current node should be the last node for prefix cars
                if (prefix.length() == 1) {
                    break;
                }
                ++i;
                current = current.middle;
                prefix = prefix.substring(1, prefix.length());
            } else if (prefix.charAt(0) < current.data) {
                //go left
                current = current.left;
            } else {
                //go right
                current = current.right;
            }
        }
        return current;
    }

    private void traverse(TernaryNode current, String prefix, List list) {
        if (current == null) {
            return;
        }
        traverse(current.left, prefix, list);
        if (current.isWord) {
            list.add(prefix + current.data);
        }
        traverse(current.middle, prefix + current.data, list);
        traverse(current.right, prefix, list);
    }
}

class TernaryNode {
    boolean isWord;
    char data;
    TernaryNode left;
    TernaryNode middle;
    TernaryNode right;

    public TernaryNode(char c) {
        this.data = c;
    }
}