package longestIncreasingMatrixPath;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Leetcode
 * Created by Ventus on 2019/11/21 4:45 PM
 */

public class LongestIncreasingMatrixPath {
    public static int solution(int[][] matrix) {
        if (null == matrix) return 0;
        int row = matrix.length;
        if (null == matrix[0]) return 0;
        int col = matrix[0].length;
        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                points.add(new Point(i,j, matrix[i][j]));
            }
        }

        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.val - o2.val;
            }
        });

        int[][] table = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                table[i][j] = 1;
            }
        }

        int l = 1;
        for (Point point : points) {
            int i = point.row;
            int j = point.col;
            int path = 1;
            if ( j > 0 && matrix[i][j-1] < point.val && path < table[i][j-1] + 1) {
                path = table[i][j-1] + 1;
            }
            if (j < col - 1 && matrix[i][j+1] < point.val && path < table[i][j+1] + 1) {
                path = table[i][j+1] + 1;
            }
            if (i < row - 1 && matrix[i+1][j] < point.val && path < table[i+1][j] + 1) {
                path = table[i+1][j] + 1;
            }
            if (i > 0 && matrix[i-1][j] < point.val && path < table[i-1][j] + 1) {
                path = table[i-1][j] + 1;
            }
            table[i][j] = path;
            l = l < path ? path : l;
        }

        return l;
    }

    public static class Point {
        int row;
        int col;
        int val;

        Point(int r, int c, int v) {
            this.row = r;
            this.col = c;
            this.val = v;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{3,4,5}, {3,2,6},{2,2,1}};
        System.out.println(solution(matrix));
    }
}
