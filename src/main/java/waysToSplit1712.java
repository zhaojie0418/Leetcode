import java.util.Arrays;

public class waysToSplit1712 {
    public static void main(String[] args) {
        System.out.println(new waysToSplit1712().waysToSplit(new int[]{1,2,2,2,5,0}));
    }
    public int waysToSplit(int[] nums) {
        //这里应当使用前缀和，而不是用专门的值来记录和
        int length = nums.length;
        final int MOD = 1000000000 + 7;

        //计算前缀和
        int[] prefixNums = new int[length];
        int tempSum = 0;
        for (int i = 0; i < nums.length; i++) {
            tempSum += nums[i];
            prefixNums[i] = tempSum;
        }

        int sum = Arrays.stream(nums).sum();
        long count = 0L;
        for (int left = 0; left < length - 2; left++) {
            for (int right = left + 1; right < length - 1; right++) {
                if ((check(prefixNums[left], prefixNums[right] - prefixNums[left], sum - prefixNums[right]))) {
                    count++;
                }
            }
        }
        return (int) (count % MOD);
    }

    public boolean check(int left, int mid, int right) {
        return (left <= mid && mid <= right);
    }
}
