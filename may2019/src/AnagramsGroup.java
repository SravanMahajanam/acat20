import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AnagramsGroup {
    public static void anagramsGroup1(String[] in) {
        boolean[] added = new boolean[in.length];
        for (int i = 0; i<in.length;++i) {
            if(added[i])
                continue;
            System.out.print(in[i] + " - ");
            for (int j = 0; j<in.length;++j) {
                if(Anagrams.areAnagrams2(in[i], in[j])) {
                    System.out.println(in[j] + " ");
                    added[j] = true;
                }
            }
            System.out.println();
        }
    }

    public static void anagramsGroup3(String[] in) {
        HashMap<String, ArrayList<String>> anagMap = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i<in.length;++i) {
            char[] inChar = in[i].toCharArray();
            Arrays.sort(inChar);
            String  sortedStr = new String(inChar);
            if (anagMap.get(sortedStr) == null) {
                ArrayList<String> anagList = new ArrayList<String>();
                anagList.add(in[i]);
                anagMap.put(sortedStr, anagList);
            } else {
                anagMap.get(sortedStr).add(in[i]);
            }
        }
        System.out.println(anagMap);
    }

    /*public static void anagramsGroup2(String[] in) {
        String[] anagArray = new String[in.length];
        Arrays.copyOf(in, in.length);
        for (int i = 0; i<in.length;++i) {
            char[] inChar = in[i].toCharArray();
            Arrays.sort(inChar);
            String  sortedStr = new String(inChar);
            if (anagMap.get(sortedStr) == null) {
                ArrayList<String> anagList = new ArrayList<String>();
                anagList.add(in[i]);
                anagMap.put(sortedStr, anagList);
            } else {
                anagMap.get(sortedStr).add(in[i]);
            }
        }
        System.out.println(anagMap);
    }*/

    public static void main(String[] args) {
        String[] in = {"abc", "bca", "pqr", "xyz", "cba", "aaa", "bbb", "qrp"};
        anagramsGroup3(in);
    }
}
