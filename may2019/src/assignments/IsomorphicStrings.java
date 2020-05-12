/*
package assignments;

import java.util.HashMap;

public class IsomorphicStrings {

    public static boolean areIsomorphic(String s, String t) {
        char[] sChar = s.toCharArray();
        int sRange = 0;
        for (int i = 0; i<sChar.length-1;++i) {
            if (sChar[i] != sChar[i+1]) {
                ++sRange;
            }
        }

        char[] tChar = t.toCharArray();
        int tRange = 0;
        for (int i = 0; i<tChar.length-1;++i) {
            if (tChar[i] != tChar[i+1]) {
                ++tRange;
            }
        }
        return sRange == tRange;
    }

    */
/* This doesn't looks to be correct and bit confusing as well
    public static boolean areIsomorphicCopied(String s, String t) {
        // we have to maintain the non-repeated chars count (as above method)
        // and the occurrence details (in "aba" a range is 1 + 3 = 4; b range is 2) of each char,
        // so that we know if they can be correctly replaced with a different character to get the other string
        //
        // assuming only three letters (a, b, c) are allowed in the input
        // for aba range is [4,2,0] and bab [2,4,0], this implies that occurrence of 'a' in two strings are different
        // so we cannot replace with other char to make the string same.
        int[] range = new int[512];
        for (int i = 0; i< s.length();++i) {
            if(range[s.charAt(i)] != range[t.charAt(i)]) {
                return false;
            }
            range[s.charAt(i)] = i + 1;
            range[t.charAt(i) + 256] = i+1;
        }
        return true;
    }*//*


    public static void main(String[] args) {
        System.out.println(areIsomorphicCopied("aba", "bab"));

    }
}
*/
