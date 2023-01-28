public class minSideJumps1824 {
    public static void main(String[] args) {
        System.out.println(new minSideJumps1824().minSideJumps(new int[]{0,1,2,3,0}));
    }
    public int minSideJumps(int[] obstacles) {
        int now = 2;
        int jumpCount = 0;
        for (int i = 0; i < obstacles.length; i++) {
            int obstacle = obstacles[i];
            if (obstacle == now) {
                jumpCount++;
                int x = (now + 1) % 3;
                int y = (now - 1) % 3;
                if (x == 0) {
                    x = 3;
                }
                if (y == 0) {
                    y = 3;
                }
                obstacle = obstacles[--i];
                while (obstacle != x && obstacle != y) {
                    i++;
                    if (i >= obstacles.length) {break;}
                    obstacle = obstacles[i];
                }
                if (i > obstacles.length) {break;}
                now = obstacle == x ? y : x;
            }
        }
        return jumpCount;
    }
}
