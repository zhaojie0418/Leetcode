import java.util.Arrays;
import java.util.Comparator;

public class maxValue1751 {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3},{4, 4, 4}};
        int k = 3;
        System.out.println(new maxValue1751().maxValue(arr, k));
    }
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        int[] dp = new int[n + 1];
        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = binarySearch(events, i - 1, events[i - 1][0]);
            //如果当前这个活干了能获得更大的价值就干，并记录下对应的count（参加会议数）
            if (dp[min] + events[i - 1][2] > dp[i - 1]) {
                dp[i] = dp[min] + events[i - 1][2];
                count[i] = count[i-1]++;
            } else {
                dp[i] = dp[i - 1];
                count[i] = count[i - 1];
            }
        }
        int res = 0;
        for (int i = n; i > 0; i--) {
            if (count[i] <= k) {
                res = dp[i];
                break;
            }
        }
        return res;
    }
    public int binarySearch(int[][] jobs, int right, int target) {
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][1] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
