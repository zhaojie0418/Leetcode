package pointOffer;

public class twoSum57 {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length - 1;
        while (left < right) {
            int temp = nums[left] + nums[right];
            if (temp > target) {
                right--;
            } else if (temp < target) {
                left++;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return null;
    }
}
