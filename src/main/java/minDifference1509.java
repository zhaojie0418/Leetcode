import java.util.Arrays;

public class minDifference1509 {
    //直接排序法
    //注意当给定乱序数组，可以考虑先将其进行排序转变为有序数组再进行分析
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) {
            return 0;
        }

        Arrays.sort(nums);
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            ret = Math.min(ret, nums[n - 4 + i] - nums[i]);
        }
        return ret;
    }
}
