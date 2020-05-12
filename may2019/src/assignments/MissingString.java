package assignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MissingString {
    /**
     * @param str1: a given string
     * @param str2: another given string
     * @return: An array of missing string
     */
    public List<String> missingString(String str1, String str2) {
        // assume always str1 is larger than str2, if not rearrange
        if(str1.length() < str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        String[] str1Words = str1.split(" ");
        String[] str2Words = str2.split(" ");
        List<String> missing = new ArrayList();
        HashSet<String> set = new HashSet<>();
        for (String str: str2Words) {
            set.add(str);
        }

        for (String string: str1Words) {
            if (!set.contains(string)) {
                missing.add(string);
            }
        }
        return missing;
    }
}
