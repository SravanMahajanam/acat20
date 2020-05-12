package combinatorial;

public class SequencesBaseString {
    public static void displayAllSequences(int slots, String base) {
        auxDisplayAllSequences(slots, base, 0,"");

    }

    private static void auxDisplayAllSequences(int slots, String base, int depth, String sequence) {
        if (depth == slots) {
            System.out.println(sequence);
            return;
        }
        for (int i=0; i<base.length();++i) {
            auxDisplayAllSequences(slots, base, depth+1, sequence+base.charAt(i));

        }
    }

    public static void main(String[] args) {
        displayAllSequences(2, "abc");
    }
}
