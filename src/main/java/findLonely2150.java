import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class findLonely2150 {
    public static void main(String[] args) {
        System.out.println(new findLonely2150().findLonely(new int[]{10, 6, 5, 8}));
    }
    public List<Integer> findLonely(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        if (length == 1) {
            return Collections.singletonList(nums[0]);
        }
        if (nums[1] - nums[0] > 1) {
            list.add(nums[0]);
        }
        for (int i = 1; i < length - 1; i++) {
            if (nums[i] - nums[i - 1] > 1 && nums[i + 1] - nums[i] > 1) {
                list.add(nums[i]);
            }
        }
        if (nums[length-1] - nums[length-2] > 1) {
            list.add(nums[length - 1]);
        }
        return list;
    }
}
