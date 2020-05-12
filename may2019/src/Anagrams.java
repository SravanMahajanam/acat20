import java.util.Arrays;

public class Anagrams {
    public static boolean areAnagrams1(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        char[] s1Char = s1.toCharArray();
        char[] s2Char = s2.toCharArray();

        Arrays.sort(s1Char);
        Arrays.sort(s2Char);

        for (int i = 0; i < s1.length(); ++i) {
            if (s1Char[i] != s2Char[i])
                return false;
        }
        return true;
    }

    public static boolean areAnagrams2(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        char[] s1Char = s1.toCharArray();
        char[] s2Char = s2.toCharArray();

        char[] tempArray = new char[26];
        for (int i = 0; i<s1Char.length;++i) {
            ++tempArray[s1Char[i] - 'a'];
        }

        for (int i = 0; i<s2Char.length;++i) {
            if (tempArray[s2Char[i] - 'a'] == 0)
                return false;
            --tempArray[s2Char[i] - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(areAnagrams2("abcd", "bcda"));
    }
}
