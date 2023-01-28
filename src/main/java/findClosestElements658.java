import java.util.ArrayList;
import java.util.List;

public class findClosestElements658 {
    //和官方的算法相同，先使用二分查找找到对应的位置，然后在使用双指针分别从这个数字左右移动
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int right = binarySearch(arr, x);
        int left = right - 1;
        while (k-- > 0) {
            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
            } else if (x - arr[left] <= arr[right] - x) {
                left--;
            } else {
                right++;
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = left + 1; i < right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    //之所以当arr[mid] == x 时不直接返回的原因在于
    //该解法并不是标准的二分查找，存在数组中没有给定数字的情况，而且在这种情况下还不能返回-1
    //并且当数组中存在多个给定数字时，根据题意需要返回到最左边的给定数字
    //所以该题中的二分查找并不是标准的二分查找
    public int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
