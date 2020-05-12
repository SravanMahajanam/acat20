package optimization;

public class EditDistance_Prac {
    public static int editDistance(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] memory = new int[s1.length()][s2.length()];
        for (int row = 0 ; row<=l1; ++row) {
            memory[row][l2] = l1-row;
        }
        for (int col = 0; col<l2; ++col) {
            memory[l1][col] = l2-col;
        }

        for (int row = l1-1; row>=0 ; --row) {
            for (int col = l2-1; col>=0;--col) {
                if (s1.charAt(row) == s2.charAt(col)) {
                    memory[row][col] = memory[row+1][col+1];
                } else {
                    memory[row][col] = Math.min(memory[row+1][col+1]+1, Math.min(memory[row+1][col] + 1, memory[row][col+1] + 1));
                }
            }
        }
        return memory[0][0];
    }
}
