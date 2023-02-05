public class search33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //关键在于这种特殊二分的情况
            if (nums[0] <= nums[mid]) { //在左半拉
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1; //左左
                } else {
                    l = mid + 1;
                }
            } else {  //在右半拉
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
