public class minMaxGame2293 {
    public int minMaxGame(int[] nums) {
        int length = nums.length;
        while (length > 1) {
            for (int i = 0; i < length / 2; i++) {
                if (i % 2 == 0) {
                    nums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    nums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            length = length / 2;
        }
        return nums[0];
    }
}
