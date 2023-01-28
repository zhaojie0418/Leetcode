public class findBall1706 {
    //官方题解
    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] ans = new int[n];
        for (int j = 0; j < n; j++) {
            int col = j;  // 球的初始列
            for (int[] row : grid) {
                int dir = row[col];
                //注意对应的位置为1 则说明向右移动 对应的位置为-1 则说明向左移动
                col += dir;  // 移动球
                //col始终标记为球所在的位置，dir指示的是对应方格原本的方向
                //一直向dir设定的方向移动，直至遇到墙壁和夹角
                if (col < 0 || col == n || row[col] != dir) {  // 到达侧边或 V 形
                    col = -1;
                    break;
                }
            }
            ans[j] = col;  // col >= 0 为成功到达底部
        }
        return ans;
    }

}
