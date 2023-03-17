import java.util.Arrays;
import java.util.Comparator;

public class answerQueries2389 {
    public static void main(String[] args) {
        int[] arr1 = {4, 5, 2, 1};
        int[] arr2 = {3, 10, 21};
        System.out.println(Arrays.toString(new answerQueries2389().answerQueries(arr1, arr2)));
    }
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; ++i) {
            nums[i] += nums[i - 1];
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            ans[i] = search(nums, queries[i]);
        }
        return ans;
    }

    private int search(int[] nums, int x) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] > x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
