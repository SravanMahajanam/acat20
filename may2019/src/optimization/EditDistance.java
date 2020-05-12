package optimization;

public class EditDistance {
    public static int editDistance4(String s1, String s2) {
        int[][] memory = new int[s1.length()+1][s2.length()+1];

        for (int i=0;i<s2.length();++i) {
            memory[s1.length()][i] = s2.length()-i;
        }
        for (int j=0;j<s1.length();++j) {
            memory[j][s2.length()] = s1.length()-j;
        }

        for (int i=s1.length()-1;i>=0;--i) {
            for (int j = s2.length()-1;j>=0;--j) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    memory[i][j] = memory[i+1][j+1];
                } else {
                    memory[i][j] = Math.min(memory[i+1][j]+1, Math.min(memory[i+1][j+1]+1, memory[i] [j+1]+1));
                }
            }
        }
        return memory[0][0];
    }

    public static void main(String[] args) {
        String s1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String s2 ="pal";
        System.out.println(editDistance4(s1,s2));
    }
}
