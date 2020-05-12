package assignments;

import java.util.ArrayList;
import java.util.List;

public class SprialMatrix {

    public static List spiralOrder(int[][] matrix) {
        ArrayList list = new ArrayList();
        if(matrix.length == 0)
            return list;
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; ++i) {
                list.add(matrix[top][i]);
            }
            top++;
            if (top > bottom)
                break;
            for (int i = top; i <= bottom; ++i) {
                list.add(matrix[i][right]);
            }
            right--;
            if (left > right)
                break;
            for (int i = right; i >= left; --i) {
                list.add(matrix[bottom][i]);
            }
            bottom--;
            if (top > bottom)
                break;
            for (int i = bottom; i >= top; --i) {
                list.add(matrix[i][left]);
            }
            left++;
            if (left > right)
                break;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] in = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(in));

    }
}
