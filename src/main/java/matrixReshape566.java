public class matrixReshape566 {
    public static void main(String[] args) {

    }
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        //注意对二位数组的行列的取值
        int m = nums.length;
        int n = nums[0].length;
        if(m*n!=r*c){
            return nums;
        }
        int[][] ans = new int[r][c];
        //注意使用巧妙的映射关系
        for (int x = 0; x < m * n; ++x) {
            // x / c 是第x个数对应的行数
            // x % c 是第x个数对应的列数
            ans[x / c][x % c] = nums[x / n][x % n];
        }
        return ans;
    }
}
