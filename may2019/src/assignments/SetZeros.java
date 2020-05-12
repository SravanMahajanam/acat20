package assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetZeros {
    public static int[][] setZeroes(int[][] matrix) {
        List rowList = new ArrayList();
        List columnList = new ArrayList();
        for (int row=0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix[0].length; ++col) {
                if (matrix[row][col] == 0) {
                    rowList.add(row);
                    columnList.add(col);
                }
            }
        }

        for (int index = 0; index < rowList.size();++index) {
            int i = (Integer) rowList.get(index);
            for (int j = 0 ; j < matrix[0].length; ++j) {
                matrix[i][j] = 0;
            }
        }

        for (int index = 0; index < columnList.size(); ++index) {
            int j = (Integer) columnList.get(index);
            for (int i = 0 ; i < matrix.length; ++i) {
                matrix[i][j] = 0;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] a = new int[][] {
                        {0,1,2,0},
                        {3,4,5,2},
                        {1,3,1,5}
                    };
        a =  setZeroes(a);
        for(int i=0;i<a.length;i++) {
            System.out.println(Arrays.toString(a[i]));
        }

    }
}
