import java.util.Arrays;
import java.util.Comparator;

public class minTaps1326 {
    public int minTaps(int n, int[] ranges) {
        //将当前题目看成是求桥梁最多能够抵达的结点，在能够选择的下一个结点中选择能够到达的最末结点
        int[][] intervals = new int[n + 1][];//初始化结点数组
        for (int i = 0; i <= n; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            intervals[i] = new int[]{start, end};
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));//按起始点进行排序
        int resCount = 0;
        int tempMax = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < n; i++) {
            while (intervals[index][0] <= i) {
                tempMax = Math.max(tempMax, intervals[index][1]);
                index++;
            }
        }
        return resCount;
    }
}
