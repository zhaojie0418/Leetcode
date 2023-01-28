public class isMonotonic896 {
    public boolean isMonotonic(int[] nums) {
        //题目中是根据连续两个元素来判断数组是递增还是递减，但容易导致 2,2,3的情况失误
        //所以使用第一个元素和最后一个元素做比较来判断元素是否是递增递减
        int length = nums.length;
        if (length == 1) {
            return true;
        }
        if (nums[0] > nums[length - 1]) {
            for (int i = 0; i < length - 1; i++) {
                if (nums[i] < nums[i + 1]) {
                    return false;
                }
            }
        } else if (nums[0] < nums[length - 1]) {
            for (int i = 0; i < length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < length - 1; i++) {
                if (nums[i] != nums[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
