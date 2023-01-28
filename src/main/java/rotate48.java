public class rotate48 {
    //将矩阵分为偶数和奇数进行计算
    //这里注意选取旋转的基本单位可以有所不同，可以从外层到内层寻找旋转基本单位
    //也可以直接进行分奇数偶数，然后将四个角分别分成长方形即可（更好计算）
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

}
