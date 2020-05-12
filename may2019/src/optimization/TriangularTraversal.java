package optimization;

import java.util.ArrayList;
import java.util.List;

public class TriangularTraversal {
    public static int minimumTotal(List<List<Integer>> triangle) {
        return auxMinimumTotal(triangle, 0, 0, 0);
    }

    private static int auxMinimumTotal(List<List<Integer>> triangle, int i, int j, int sum) {
        if (i == triangle.size()) {
            return 0;
        }
        if (j == triangle.get(i).size()) {
            return 0;
        }
        sum = triangle.get(i).get(j);
        int sameCol = auxMinimumTotal(triangle, i+1, j, sum);
        int nextCol = auxMinimumTotal(triangle, i+1, j+1, sum);
        return sum + Math.min(sameCol, nextCol);
    }

    public static int minimumTotal2(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int cols = triangle.get(rows-1).size();

        int[][] memory = new int[rows+1][cols+1];
        for (int i = 0; i<=rows; ++i) {
            memory[i][cols] = 0;
        }

        for (int j = 0; j<=cols; ++j) {
            memory[rows][j] = 0;
        }

        for (int i = rows-1; i>=0;--i) {
            for (int j = cols-1;j>=0;--j) {
                if (j>=triangle.get(i).size()) {
                    continue;
                }
                memory[i][j] = triangle.get(i).get(j) + Math.min(memory[i+1][j], memory[i+1][j+1]);
            }
        }
        return memory[0][0];
    }

    public static void main(String[] args) {
        List<List> list = new ArrayList<List>();
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(new Integer(1));
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(new Integer(3));
        list2.add(new Integer(2));
        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(new Integer(5));
        list3.add(new Integer(7));
        list3.add(new Integer(6));
        List<Integer> list4 = new ArrayList<Integer>();
        list4.add(new Integer(9));
        list4.add(new Integer(10));
        list4.add(new Integer(4));
        list4.add(new Integer(8));
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        //System.out.println(minimumTotal(list));
    }
}
