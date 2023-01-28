public class getSumAbsoluteDifferences1685 {
    public static void main(String[] args) {
        System.out.println(new getSumAbsoluteDifferences1685().getSumAbsoluteDifferences(new int[]{2,3,5}));
    }
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            nums[i] += nums[i - 1];
        }
        int lastSum = nums[0];
        nums[0] = (1 - length) * nums[0] + nums[length - 1] - nums[0];
        for (int i = 1; i < length; i++) {
            int temp = lastSum;
            lastSum = nums[i];
            int num = nums[i] - temp;
            nums[i] = (2 * i - length + 1) * num + nums[length - 1] - temp - nums[i];
        }
        return nums;
    }
}
