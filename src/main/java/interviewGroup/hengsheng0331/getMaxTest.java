package interviewGroup.hengsheng0331;

public class getMaxTest {
    public static void main(String[] args) {
//        10000,7,[1.0, 2.0, 1.0,2.0, 2.0, 3.0, 2.0],2
        double M = 10000;
        int N = 7;
        double[] arr = {1.0, 2.0, 1.0, 10.0, 2.0, 3.0, 2.0};
        int K = 2;
        System.out.println(new get_max_profit().get_max_profit2(M, N, arr, K));

    }
    public double get_max_profit2 (double M, int N, double[] historyPrices, int K) {
        if (K >= N / 2) {
            double res = 0.0;
            for (int i = 1; i < N; i++) {
                if (historyPrices[i] > historyPrices[i - 1]) {
                    res += historyPrices[i] - historyPrices[i - 1];
                }
            }
            return res * M;
        } else {
            double[][] dp = new double[N][K+1];
            for (int j = 1; j <= K; j++) {
                double maxDiff = -historyPrices[0];
                for (int i = 1; i < N; i++) {
                    dp[i][j] = dp[i - 1][j];
                    maxDiff = Math.max(maxDiff, dp[i - 1][j - 1]);
                    dp[i][j] = Math.max(dp[i][j], maxDiff + historyPrices[i]);
                }

            }
            return Math.min(M*dp[N - 1][K], Double.MAX_VALUE);
        }
    }
}
