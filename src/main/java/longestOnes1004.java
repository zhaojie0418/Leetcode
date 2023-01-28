public class longestOnes1004 {
    public static void main(String[] args) {


    }
    public static int longestOnes(int[] nums, int k) {
        int length = nums.length;
        int ans = 0;
        for (int left = 0, right = 0, sum = 0; right < length; right++) {
            sum += nums[right]!= 1 ? 1 : 0;
            while (sum > k) {
                sum -= nums[left++] != 1 ? 1 : 0;
            }
            //取每一次滑动过程中的滑动窗口最大值
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
