package assignments;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNA {
    public static List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> list = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; ++i) {
            String seq = s.substring(i, i + 10);
            if (set.contains(seq)) {
                list.add(seq);
            }
            set.add(seq);
        }
        return new ArrayList<String>(list);
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
