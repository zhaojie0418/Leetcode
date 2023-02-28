import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class maxAverageRatio1792 {
    public static void main(String[] args) {
//        [[1,2],[3,5],[2,2]]
//        2
        System.out.println(new maxAverageRatio1792().maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {2, 2}}, 2));
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
            //判断依据是假设添加好学生后的增长率
            long val1 = (long) (b[1] + 1) * b[1] * (a[1] - a[0]);
            long val2 = (long) (a[1] + 1) * a[1] * (b[1] - b[0]);
            if (val1 == val2) {
                return 0;
            }
            return val1 < val2 ? 1 : -1;
        });
        for (int[] c : classes) {
            pq.offer(new int[]{c[0], c[1]});
        }

        //给每一个好学生都分配好对应的位置
        for (int i = 0; i < extraStudents; i++) {
            int[] arr = pq.poll();
            int pass = arr[0], total = arr[1];
            pq.offer(new int[]{pass + 1, total + 1});
        }

        double res = 0;
        for (int i = 0; i < classes.length; i++) {
            int[] arr = pq.poll();
            int pass = arr[0], total = arr[1];
            res += 1.0 * pass / total;
        }
        return res / classes.length;
    }
}