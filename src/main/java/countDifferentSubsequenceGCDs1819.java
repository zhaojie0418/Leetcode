import java.util.Arrays;
import java.util.HashSet;

public class countDifferentSubsequenceGCDs1819 {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }

        return hashSet.size();
    }
}
