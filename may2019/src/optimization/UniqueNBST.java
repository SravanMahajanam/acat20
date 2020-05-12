package optimization;

public class UniqueNBST {
    public static int numTrees(int n) {
        int[] trees = new int[n];
        return auxNumTrees(n, trees);
    }

    private static int auxNumTrees(int n, int[] trees) {

        int treesCount = 0;
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int left = 0, right = 0;
        for (int i = 0; i < n; ++i) {
            if (trees[i] == 0) {
                trees[i] = auxNumTrees(i, trees);
            }
            if (trees[n - 1 - i] == 0) {
                trees[n - 1 - i] = auxNumTrees(n - i - 1, trees);
            }
            treesCount += trees[i] * trees[n - 1 - i];
        }

        return treesCount;
    }

    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }
}

