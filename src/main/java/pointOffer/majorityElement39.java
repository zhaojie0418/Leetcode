package pointOffer;

import java.util.Arrays;

public class majorityElement39 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
