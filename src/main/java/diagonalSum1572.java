public class diagonalSum1572 {
    //根据对角线条件(i == j || i + j == n - 1)
    public int diagonalSum(int[][] mat) {
        int n = mat.length, sum = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j || i + j == n - 1) {
                    sum += mat[i][j];
                }
            }
        }
        return sum;
    }
    //上一种算法很傻，实际上只要将数学规律写到里面就可以使时间复杂度从平方降到一次方
    //逐行遍历，记当前的行号为 ii，对于一行我们把 (i, i)(i,i) 位置和 (i, n - i - 1)(i,n−i−1) 加入答案。
    //这样如果 nn 是奇数的话，最中间的格子会被加入两次。所以 nn 为奇数的时候，我们需要减掉矩阵最中心的那个值。
    public int diagonalSum2(int[][] mat) {
        int n = mat.length, sum = 0, mid = n / 2;
        for (int i = 0; i < n; ++i) {
            sum += mat[i][i] + mat[i][n - 1 - i];
        }
        return sum - mat[mid][mid] * (n & 1);
    }

}
