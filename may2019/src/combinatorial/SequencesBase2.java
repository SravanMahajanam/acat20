package combinatorial;

public class SequencesBase2 {
    public static void displayAllSequences(int slots, int base) {
        auxDisplayAllSequences(slots, base, 0,"");

    }

    private static void auxDisplayAllSequences(int slots, int base, int depth, String sequence) {
        if (depth == slots) {
            System.out.println(sequence);
            return;
        }
        for (int i=0; i<base;++i) {
            auxDisplayAllSequences(slots, base, depth+1, sequence+i);

        }
    }

    public static void main(String[] args) {
        displayAllSequences(2, 3);
    }
}
