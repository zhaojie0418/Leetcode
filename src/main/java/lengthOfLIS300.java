import java.util.ArrayList;
import java.util.List;

public class lengthOfLIS300 {
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new lengthOfLIS300().lengthOfLIS(arr));
    }
    //这里首先考虑最暴力的解法每一位都进行遍历,并进行记录,实际上这种算法不正确因为这里相当于是将字符串看做一个单位进行计数，实际上只需要对位数进行计数即可
    public int lengthOfLIS(int[] nums) {
        //使用undeterminedResult存放所有待定的数组，其中第一个数字表示最末尾的最大数字，第二个数字表示数组长度
        List<int[]> undeterminedResult = new ArrayList<>();
        //对待选列表进行初始化
        undeterminedResult.add(new int[]{nums[0],1});
        for (int i = 1; i < nums.length; i++) {
            //注意这里地方对undeterminedResult进行了修改自然不能再运行
            boolean allSmall = true;
            for (int[] tempArr : undeterminedResult) {
                //计数加一并且替代最末尾的为更大的元素
                //这里实际上要考虑要不要增加这个新元素，可能如果增加了这个新元素导致后面的更小的元素没办法增添
                //这里分成两个均进行保留
                if (nums[i] > tempArr[0]) {
                    tempArr[0] = nums[i];
                    tempArr[1]++;
                    allSmall = false;
                }
            }
            if(allSmall){
                undeterminedResult.add(new int[]{nums[i], 1});
            }
        }
        int max = 0;
        for (int[] tempArr : undeterminedResult) {
            max = Math.max(tempArr[1],max);
        }
        return max;
    }

    //使用动态规划的思想
    //dp[i] 意为，第i位数字为结尾时能够形成的最长子序列
    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        //所有位数的初始值都为 1
        int maxAns = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }

    //贪心+二分
    public int lengthOfLIS3(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

}
