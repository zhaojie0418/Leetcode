import java.util.Arrays;

public class minPairSum1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        int length = nums.length;
        for(int i = 0;i<length/2;i++){
            max = Math.max(max,nums[i]+nums[length-i-1]);
        }
        return max;
    }
}
