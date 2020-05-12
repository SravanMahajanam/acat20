package optimization;

public class CoinChange_Prac {
    public static int cointCount1(int[] coins, int sum) {
        MyInteger count = new MyInteger(Integer.MAX_VALUE);
        auxCointCount1(coins, 0, 0, count, sum);
        return count.get();
    }

    private static void auxCointCount1(int[] coins, int index, int currSum, MyInteger count, int sum) {
        if (sum == 0) {
            if (currSum < count.get()) {
                count.set(currSum);
            }
        }
        if (index == coins.length || sum<coins[index]) {
            return;
        }

        auxCointCount1(coins,index, currSum+1, count,sum - coins[index]);
        auxCointCount1(coins,index+1, currSum,count,sum);
    }

    public static int coinsCount2(int[] coins, int sum) {
        return auxCoinsCount2(coins, 0, sum);
    }

    private static int auxCoinsCount2(int[] coins, int index, int sum) {
        if (sum == 0) {
            return 0;
        }
        if (index == coins.length || sum<coins[index]) {
            return Integer.MAX_VALUE;
        }
        int inclusive = auxCoinsCount2(coins , index,sum-coins[index] );
        if (inclusive!=Integer.MAX_VALUE) {
            inclusive = inclusive + 1;
        }
        int exclusive = auxCoinsCount2(coins, index+1,sum);
        return Math.min(inclusive, exclusive);
    }

    public static int coinsCount3(int[] coins, int sum) {
        int[][] memory = new int[coins.length][sum];
        auxCoinsCount3(coins, sum, 0, memory);
        return memory[0][0];
    }

    private static int auxCoinsCount3(int[]  coins, int sum, int index, int[][] memory) {
        if (sum == 0) {
            return 0;
        }
        if (index == coins.length || sum<coins[index]) {
            return Integer.MAX_VALUE;
        }
        if (memory[index][sum] != 0) {
            return memory[index][sum];
        }
        int inclusive = auxCoinsCount2(coins , index,sum-coins[index] );
        if (inclusive!=Integer.MAX_VALUE) {
            inclusive = inclusive + 1;
        }
        int exclusive = auxCoinsCount2(coins, index+1,sum);
        memory[index][sum] = Math.min(inclusive, exclusive);
        return memory[index][sum];
    }

    public static int coinsCount4(int[] coins, int sum) {
        int[][] memory = new int[coins.length+1][sum+1];
        for (int row = 0; row<coins.length;++row) {
            memory[row][0] = 0;
        }
        for (int col = 0; col<=sum;++col) {
            memory[coins.length][col] = Integer.MAX_VALUE;
        }
        for (int row = coins.length-1; row>=0;--row) {
            for (int col = 1; col<=sum; ++col) {
                if (sum<coins[row]) {
                    memory[row][col] = Integer.MAX_VALUE;
                } else {
                    int include = memory[row][sum - coins[row]];
                    if (include != Integer.MAX_VALUE) {
                        include = include + 1;
                    }
                    memory[row][col] = Math.min(include, memory[row + 1][sum]);
                }
            }
        }
        return memory[0][sum];
    }

    public static void main(String[] args) {
        System.out.println(coinsCount4(new int[]{1,3,4}, 6));
    }
}
