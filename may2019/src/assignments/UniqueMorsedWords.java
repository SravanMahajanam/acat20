package assignments;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueMorsedWords {

    // for each word in the array calculate the morse code and add it to set. Set size will tell the unique morse words.
    public static int uniqueMorsedWords(String[] in) {
        String[] morseCodes = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....","..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> morsedStrings = new HashSet<>();
        for (String string: in) {
            String morsed = "";
            for (char c: string.toCharArray()) {
                morsed = morsed + morseCodes[ c - 97];
            }
            morsedStrings.add(morsed);
        }
        return morsedStrings.size();

    }
}
