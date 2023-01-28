import java.util.Arrays;

public class sortedSquares977 {
    public int[] sortedSquares(int[] nums) {
        for(int i =0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
//    同样地，我们可以使用两个指针分别指向位置 0和 n−1，每次比较两个指针对应的数，选择较大的那个逆序放入答案并移动指针
//            这种方法无需处理某一指针移动至边界的情况

    public int[] sortedSquares2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return ans;
    }

}
