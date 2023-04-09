package interviewGroup.hengsheng0331;

import java.util.Arrays;

public class get_max_profit {
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
            double res = M;
            for (int i = 1; i < N; i++) {
                if (historyPrices[i] > historyPrices[i - 1]) {
                    res = historyPrices[i] * (res / historyPrices[i - 1]);
                }
            }
            return res;
        } else {
            double[][] dp = new double[N][K+1];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dp[i], 1);
            }
            for (int j = 1; j <= K; j++) {
                double minPrice = historyPrices[0];
                int minIndex = 0;
                for (int i = 1; i < N; i++) {
                    minPrice = Math.min(minPrice, historyPrices[j] - dp[i][j - 1]);
                    if (historyPrices[i] / minPrice > dp[i - 1][j]) {
                        dp[i][j] = historyPrices[i] / minPrice;
                        minIndex = i;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
                for (int i = 0; i < N; i++) {
                    minPrice = Math.min(minPrice, historyPrices[i] - dp[i][j - 1]);
                    if ((historyPrices[i] / minPrice) * dp[minIndex][j - 1] > dp[i][j]) {
                        dp[i][j] = (historyPrices[i] / minPrice) * dp[minIndex][j - 1];
                    }
                }

            }

            return M*dp[N - 1][K];
        }
    }
}
