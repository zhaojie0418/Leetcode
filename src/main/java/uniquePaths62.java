import java.util.LinkedList;
import java.util.Queue;

public class uniquePaths62 {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};
    //注意这题不应该使用DFS算法，首先注意题目要求是路径的个数而不是具体的路径，所以不需要使用DFS算法做额外的遍历
    //由于机器人只能往右边或者往下走，所以抵达某一格的路径数量取决于左一格和上一格的和
    public int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];
        for (int i = 0; i < m; ++i) {
            map[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            map[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        return map[m - 1][n - 1];
    }
}
