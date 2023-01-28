public class maxSubArray53 {
    public static void main(String[] args) {

    }
    //使用了动态规划，最大子序列的前提条件是f(i)=max{f(i−1)+nums[i],nums[i]}
    //如果我是后面的数字，我肯定希望前面传给我一个正数，给我一个负数把我变小，那我不如只要自己
    //从零开始不断迭代，如果每一个前一步都已经是前一步的最大值了，那么 组成 就一定是最大值
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
