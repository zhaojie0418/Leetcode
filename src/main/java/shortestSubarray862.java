public class shortestSubarray862 {

    public static void main(String[] args) {
        System.out.println(new shortestSubarray862().shortestSubarray(new int[]{84,-37,32,40,95},167));
    }
    //这里起初尝试使用滑动数组方式解决，但是由于其中存在负数的原因，滑动数组需要滑动所有的数，导致效率不高
    public int shortestSubarray(int[] nums, int k) {
        return minSubArrayLen(k,nums);
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
        return change ? res : -1;
    }
}
