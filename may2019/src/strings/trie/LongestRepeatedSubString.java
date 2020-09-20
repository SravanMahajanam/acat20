package strings.trie;

import java.util.Arrays;

public class    LongestRepeatedSubString {

    public static int longRepSubStr1(String string) {
        int maxLength = 0;
        for (int i = 0; i < string.length(); ++i) {
            for (int j = i + 1; j < string.length(); ++j) {
                int max = commonPrefixLength1(string, i, j);
                maxLength = Math.max(maxLength, max);
            }
        }
        return maxLength;
    }

    private static int commonPrefixLength1(String s, int i, int j) {
        int l = 0;
        while (j < s.length()) {
            if (s.charAt(i++) == s.charAt(j++)) {
                ++l;
            } else {
                break;
            }
        }
        return l;
    }

    public static int longRepSubStr2(String string) {
        int maxLength = 0;
        int n = string.length();
        String[] suffixes = new String[n];
        for (int i = 0; i < n; ++i) {
            suffixes[i] = string.substring(i);
        }
        Arrays.sort(suffixes);

        for (int i = 1; i < n; ++i) {
            int max = commonPrefixLength2(suffixes[i], suffixes[i - 1]);
            maxLength = Math.max(maxLength, max);
        }
        return maxLength;
    }

    private static int commonPrefixLength2(String suffix1, String suffix2) {
        int l = 0;
        int i = 0, j = 0;
        while (i < suffix1.length() && j < suffix2.length()) {
            if (suffix1.charAt(i++) == suffix2.charAt(j++)) {
                ++l;
            } else {
                break;
            }
        }
        return l;
    }

    public static int longRepSubStr3(String string) {
        int maxLength = 0;
        ITrie trie = new MultiwayTrie();
        for (int i = 0; i < string.length(); ++i) {
            String lcpString = trie.lcp(string.substring(i));
            maxLength = Math.max(maxLength, lcpString == null ? 0 : lcpString.length());
            trie.add(string.substring(i));
        }
        return maxLength;
    }

    public static int longRepSubStr4(String string) {
        int maxLength = 0;
        int n = string.length();
        int[][] memory = new int[n + 1][n + 1];

        for (int i = 0; i < n; ++i) {
            memory[i][n] = 0;
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (string.charAt(i) != string.charAt(j)) {
                    memory[i][j] = 0;
                } else {
                    memory[i][j] = 1 + memory[i + 1][j + 1];
                    maxLength = Math.max(maxLength, memory[i][j]);
                }
            }
        }
        return maxLength;
    }
}
