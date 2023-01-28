import java.util.Arrays;

public class partitionArray2294 {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 1;
        int tempMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num - tempMin > k) {
                count++;
                tempMin = num;
            }
        }
        return count;
    }
}
