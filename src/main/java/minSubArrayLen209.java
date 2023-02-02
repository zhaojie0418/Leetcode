public class minSubArrayLen209 {
    public static void main(String[] args) {
        System.out.println(new minSubArrayLen209().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
    int res = Integer.MAX_VALUE;
    boolean change = false;
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int leftIndex = 0;
        int rightIndex = 1;
        int sum = nums[0];
        if (sum >= target) {
            return 1;
        }
        while (rightIndex < nums.length) {
            sum += nums[rightIndex];
            rightIndex++;
            while (sum >= target) {
                sum -= nums[leftIndex];
                leftIndex++;
                res = Math.min(rightIndex - leftIndex + 1, res);
                change = true;
            }
        }
        return change ? res : 0;
    }

}
