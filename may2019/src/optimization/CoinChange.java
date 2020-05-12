package optimization;

import java.util.Arrays;
import java.util.Random;

public class CoinChange {
    public static int minCoinsCount1(int[] coins, int sum) {
        MyInteger minCoins = new MyInteger(Integer.MAX_VALUE);
        auxMinCoinsCount1(coins, sum, 0, 0, minCoins);
        return minCoins.get();
    }

    private static void auxMinCoinsCount1(int[] coins, int sum, int currSum, int i, MyInteger minCoins) {
        if (sum == 0) {
            if (minCoins.get() > currSum) {
                minCoins.set(currSum);
            }
        }
        if (i == coins.length || sum < coins[i] ) {
            return;
        }
        auxMinCoinsCount1(coins, sum - coins[i], currSum + 1, i, minCoins);
        auxMinCoinsCount1(coins, sum, currSum, i + 1, minCoins);
    }

    public static int minCoinsCount2(int[] coins, int sum) {
        return auxMinCoinsCount2(coins, sum, 0);
    }

    private static int auxMinCoinsCount2(int[] coins, int sum, int i) {
        if (sum == 0) {
            return 0;
        }
        if (i == coins.length || sum < coins[i] ) {
            return Integer.MAX_VALUE;
        }
        int include = auxMinCoinsCount2(coins, sum - coins[i], i);
        if (include != Integer.MAX_VALUE) {
            include = include + 1;
        }
        int exclude = auxMinCoinsCount2(coins, sum, i+1);
        return Math.min(include, exclude);
    }

    public static int minCoinsCount3(int[] coins, int sum) {
        int[][] memory = new int[coins.length][sum+1];
        auxMinCoinsCount3(coins, sum, 0, memory);
        return memory[0][sum];
    }

    private static int auxMinCoinsCount3(int[] coins, int sum, int i, int[][] memory) {
        if (sum == 0) {
            return 0;
        }
        if (i == coins.length || sum < coins[i] ) {
            return Integer.MAX_VALUE;
        }

        if (memory[i][sum] != 0) {
            return memory[i][sum];
        }
        int include = auxMinCoinsCount3(coins, sum - coins[i], i, memory);
        if (include != Integer.MAX_VALUE) {
            include = include + 1;
        }
        int exclude = auxMinCoinsCount3(coins, sum, i+1, memory);
        int minCount = Math.min(include, exclude);
        memory[i][sum] = minCount;
        return minCount;
    }

    public static int minCoinsCount4(int[] coins, int sum) {
        int[][] memory = new int[coins.length +1][sum+1];
        for (int i = 0; i<=coins.length;++i) {
            memory[i][0] = 0;
        }
        for (int j = 1; j<= sum;++j) {
            memory[coins.length][j] = Integer.MAX_VALUE;
        }

        for (int i = coins.length -1; i>=0; --i) {
            for (int j = 1; j<=sum; ++j) {
                if (coins[i]>j) {
                    memory[i][j] = Integer.MAX_VALUE;
                } else {
                    int include = memory[i][j - coins[i]];
                    if (include != Integer.MAX_VALUE) {
                        include = include + 1;
                    }
                    int exclude = memory[i+1][j];
                    memory[i][j] = Math.min(include, exclude);
                }
            }
        }
        return memory[0][sum];
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] in = new int[n];
        Random r = new Random();
        for(int i = 0; i < n; ++i)
            in[i] = r.nextInt(10) + 1;
        Arrays.sort(in);
        System.out.println(Arrays.toString(in));
        int s = Integer.parseInt(args[1]);
        System.out.println(s);
        System.out.println(minCoinsCount1(in, s));
        System.out.println(minCoinsCount2(in, s));
        System.out.println(minCoinsCount3(in, s));
        System.out.println(minCoinsCount4(in, s));

    }
}
