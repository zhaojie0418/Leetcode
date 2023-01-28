public class maxAreaOfIsland695 {
    //由于使用了DFS需要对函数进行递归操作，所以需要使用静态变量来计算
    static int temp = 0;
    //结合统计岛屿数量算法分析
    void dfs(int[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        //如果超过二维数组边界或者是海洋
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == 0) {
            return;
        }
        //是连接着的岛屿
        grid[r][c] = 0;
        temp++;
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == 1) {
                    dfs(grid, r, c);
                    res = Math.max(res, temp);
                    temp = 0;
                }
            }
        }
        return res;
    }
}
