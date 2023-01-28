import java.util.Arrays;
import java.util.Comparator;

public class jobScheduling1235 {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][];
        //构造新的数组
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        //并且按照工作结束时间进行排序
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));
        //这里之所以要多一个位置是要留一个位置给第一个元素
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            //k 表示满足结束时间小于等于第 i - 1 份工作开始时间的兼职工作数量
            int k = binarySearch(jobs, i - 1, jobs[i - 1][0]);
            //变动的原因在于是否要干眼下这份工作，如果眼下这份工作干了导致没上一次不干工资高，那倒不如不干
            dp[i] = Math.max(dp[i - 1], dp[k] + jobs[i - 1][2]);
        }
        return dp[n];
    }

    public int binarySearch(int[][] jobs, int right, int target) {
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][1] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }



}
