import java.util.Arrays;

public class maximalNetworkRank1615 {
    public static void main(String[] args) {
        int n = 4;
        int[][] arr = {{0, 1}, {0, 3}, {1, 3}, {1, 2}};
        System.out.println(new maximalNetworkRank1615().maximalNetworkRank(n, arr));
    }
    //这里尝试先用边矩阵进行存储求解
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] edges = new int[n][n];
        int[] count = new int[n];
        for (int i = 0; i < roads.length; i++) {
            int mCount = roads[i][0];
            int nCount = roads[i][1];
            edges[mCount][nCount] = 1;
            edges[nCount][mCount] = 1;
            count[mCount]++;
            count[nCount]++;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (edges[i][j] == 1) {
                    res = Math.max(res, count[i] + count[j] - 1);
                } else {
                    res = Math.max(res, count[i] + count[j]);
                }
            }
        }
        return res;
    }
}
