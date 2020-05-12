package combinatorial;

public class AllPermutations {
    public static void printAllPermutations_completeSearch(String in) {
        auxPrintAllPermutation_completeSearch(in, "");
    }

    private static void auxPrintAllPermutation_completeSearch(String in,  String out) {
        if (out.length() == in.length()){
            if (isValid1(out)) {
                System.out.println(out);
            }
            return;
        }
        for (int i = 0; i<in.length(); ++i) {
            auxPrintAllPermutation_completeSearch(in,out+in.charAt(i));
        }
    }

    public static void printAllPermutations_backTracking(String in) {
        auxPrintAllPermutations_backTracking(in, "");
    }

    private static void auxPrintAllPermutations_backTracking(String in,  String out) {
        if (out.length() == in.length()){
            System.out.println(out);
            return;
        }
        for (int i = 0; i<in.length(); ++i) {
            if (isValid2(out, in.charAt(i))) {
                auxPrintAllPermutation_completeSearch(in,out+in.charAt(i));
            }
        }
    }

    private static boolean isValid2(String out, char c) {
        for (int i = 0; i<out.length();++i) {
            if (out.charAt(i) == c) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValid1(String out) {
        for (int i=0;i<out.length();++i) {
            for (int j = i+1; j<out.length(); ++j) {
                if (out.charAt(i) == out.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printAllPermutations_startingWithX(String in) {
        auxPrintAllPermutaions_recursion(in, "");
    }

    private static void auxPrintAllPermutaions_recursion(String in, String out) {
        if (in.length() == 0) {
            System.out.println(out);
            return;
        }
        for (int i = 0; i<in.length(); ++i) {
            auxPrintAllPermutaions_recursion(in.substring(0,i) + in.substring(i+1), out+in.charAt(i));
        }
    }

    public static void main(String[] args) {
        printAllPermutations_completeSearch("abc");
//        printAllPermutations_backTracking("abc");
        //printAllPermutations_startingWithX("abcd");
    }
}
