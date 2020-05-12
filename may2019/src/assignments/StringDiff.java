package assignments;

import java.util.Arrays;

public class StringDiff {
    public static char findTheDifference(String s, String t) {
        /*char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        for (int i = 0; i < tChar.length - 2; ++i) {
            if (tChar[i] != sChar[i]) {
                return tChar[i];
            }
        }
        return tChar[tChar.length - 1];*/
        int[] temp = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++temp[s.charAt(i) - 'a'];
        }

        for (int i = 0; i < t.length(); i++) {
            if (temp[t.charAt(i) - 'a'] == 0) {
                return t.charAt(i);
            }
            --temp[t.charAt(i) - 'a'];
        }
        return '9';
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "cabde"));
    }
}
