package combinatorial;

public class SubSets {
    public static void printSubsets(String in) {
        auxPrintSubsets_completeSearch(in, 0, "");
    }

    /*
        include/exclude each character from given string at every level,
        at last level when we will be done with including and excluding all chars from string,
        so print the subset at leaf level
    */
    private static void auxPrintSubsets_completeSearch(String in, int i, String subset) {
        if (i == in.length()) {
            System.out.println(subset);
            return;
        }
        auxPrintSubsets_completeSearch(in,i+1,subset+in.charAt(i));
        auxPrintSubsets_completeSearch(in,i+1,subset);
    }

    public static void printSubsets_startingWithX(String in) {
        auxPrintSubsets_startingWithX(in, "");
    }

    private static void auxPrintSubsets_startingWithX(String in, String subset) {
        System.out.println(subset);
        if (in.length() == 0) {
            return;
        }
        for (int i = 0; i<in.length(); ++i) {
            auxPrintSubsets_startingWithX(in.substring(i+1), subset+in.charAt(i));
        }
    }

    public static void main(String[] args) {
        //printSubsets("abc");
        printSubsets("abc");
        printSubsets_startingWithX("abc");
    }
}
