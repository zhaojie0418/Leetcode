package pointOffer;

import java.util.LinkedList;
import java.util.Queue;

public class movingCount13 {
    public static void main(String[] args) {
        System.out.println(2 / 10);//注意这里的返回结果是0
    }
    public int movingCount(int m, int n, int k) {
        boolean[][] available = new boolean[m][n];
        available[0][0] = true;
        //数组本身就是对象，所以不需要使用其对应的包装类
        Queue<int[]> queue = new LinkedList<>();
        int[] tx = {1, 0};
        int[] ty = {0, 1};
        queue.add(new int[]{0, 0});
        int res = 1;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int i = 0; i < 2; i++) {
                int x = temp[0] + tx[i];
                int y = temp[1] + ty[i];
                if (x < 0 || x >= m || y < 0 || y >= n || available[x][y] || getValue(x) + getValue(y) > k) {
                    continue;
                }
                available[x][y] = true;
                queue.offer(new int[]{x, y});
                res++;
            }
        }
        return res;
    }

    public int getValue(int i) {
        int res = 0;
        while (i != 0) {
            res += i % 10;
            i /= 10;
        }
        return res;
    }
}
