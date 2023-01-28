import java.util.Arrays;
import java.util.Comparator;

public class findLongestChain646 {
    //使用动态规划进行计算
    public int findLongestChain(int[][] pairs) {
        //存储了几个字符串
        int n = pairs.length;

        //这里两种方式对二维数组进行排序
        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
//        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        int[] dp = new int[n];
        //使用Arrays对 dp 数组进行初始化
        Arrays.fill(dp,1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                //不断对前面的元素进行遍历
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }

    //使用贪心算法
    /*要挑选最长数对链的第一个数对时，最优的选择是挑选第二个数字最小的，这样能给挑选后续的数对留下更多的空间
    挑完第一个数对后，要挑第二个数对时，也是按照相同的思路，是在剩下的数对中，第一个数字满足题意的条件下，挑选第二个数字最小的
    按照这样的思路，可以先将输入按照第二个数字排序，然后不停地判断第一个数字是否能满足大于前一个数对的第二个数字即可。*/

    public int findLongestChain2(int[][] pairs) {
        int curr = Integer.MIN_VALUE, res = 0;
        //使用第二个数进行排序
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        for (int[] p : pairs) {
            if (curr < p[0]) {
                curr = p[1];
                res++;
            }
        }
        return res;
    }

}
