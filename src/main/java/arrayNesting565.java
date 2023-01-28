import java.util.HashSet;

public class arrayNesting565 {

    public int arrayNesting(int[] nums) {
        //这里首先考虑使用HashSet进行
        HashSet<Integer> set = new HashSet<>();
       /* for (int i = 0; i < nums.length; i++) {

        }*/
        int i = 0;
        while (i < nums.length) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }
            i = nums[i];
        }
        return 0;
    }
}
