package optimization;

public class TowersOfHanoi {
    public static void hanoi1(int n, char src, char aux, char target) {
        if (n == 1) {
            System.out.println(src + " --> " + target);
            return;
        }
        hanoi1(n-1, src, target, aux);
        System.out.println(src + " --> "+ target);
        hanoi1(n-1, aux, src, target);
    }

    public static int hanoi(int n, char src, char aux, char target) {
        int[] memory = new int[n + 1];
        return auxHanoi(n, src, aux, target, memory);
    }

    public static int auxHanoi(int n, char src, char aux, char target, int[] memory) {
        for (int i = 1; i <= n; ++i) {
            memory[i] = memory[i-1] + 1 + memory[i-1];
        }
        return memory[n];
    }

    public static void main(String[] args) {
        System.out.println(hanoi(10, 'A', 'B', 'C'));
    }
}
