// [21 May] Count Square Submatrices with All Ones

class Solution {
    public int countSquares(int[][] matrix) {
        int res = 0;
        for(int  i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1 && i > 0 && j > 0) {
                    matrix[i][j] = min(matrix[i-1][j], matrix[i][j-1], matrix[i-1][j-1]) + 1;
                }
                res += matrix[i][j];
            }
        }
        return res;
    }

    int min(int a, int b, int c) {
        if(a <= b && a <= c) return a;
        else if(b <= a && b <= c) return b;
        else return c;
    }
}