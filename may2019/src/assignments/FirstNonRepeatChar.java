package assignments;

import java.util.HashMap;

public class FirstNonRepeatChar {
    public int firstUniqChar(String s) {
        char[] map = new char[256];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map[c - 97]++;
        }

        for (int i = 0; i < chars.length; ++i) {
            if (map[chars[i] - 97] == 1) {
                return i;
            }
        }
        return -1;
    }
}
