public class getMinDistance1848 {
    public int getMinDistance(int[] nums, int target, int start) {
        int min = nums.length;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == target)
                min = Math.min(min, Math.abs(i - start));
        return min;
    }
}
