package pointOffer;

public class fib10faster {
    static final int MOD = 1000000007;
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[][] temp = {{1, 1}, {1, 0}};//这里是需要求幂的因子
        int[][] res = pow(temp, n - 1);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            //注意使用与运算优于求模运算
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            a = multiply(a, a);
            n >>= 1;
        }
        return ret;
    }

    //这里定义矩阵的乘法运算
    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = (int) (((long) a[i][0] * b[0][j] + (long) a[i][1] * b[1][j]) % MOD);
            }
        }
        return c;
    }

}