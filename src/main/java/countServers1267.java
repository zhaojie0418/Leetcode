public class countServers1267 {
    public int countServers(int[][] grid) {
        int x = grid[0].length;
        int y = grid.length;
        int[] countX = new int[x];
        int[] countY = new int[y];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (grid[i][j] == 1) {
                    countX[j]++;
                    countY[i]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (grid[i][j] == 1 && (countX[j] > 1 || countY[i] > 1)) {
                    res++;
                }
            }
        }
        return res;
    }
}
