import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class minMoves1703 {
    public int minMoves(int[] nums, int k) {
        int n = nums.length;
        int[] pos = new int[n];
        int index = 0;
        // 例如：[1,0,0,1,0,1,1,1,0,1,1] => [0,3,5,6,7,9,10]
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                pos[index++] = i;
            }
        }
        int ans = 0, count = 0, mid = k / 2;
        // 定长滑窗模板:
        // 1.计算第一个长度为k的窗口, k = 5, pos[i] - pos[i - 1] - 1表示相邻1之间0的个数
        // [0,3,5,6,7] => (3-0-1)*1 + (5-3-1)*2 + (6-5-1)*2 + (7-6-1)*1 = 4
        for (int i = 1; i < k; i++) {
            count += (pos[i] - pos[i - 1] - 1) * Math.min(i, k - i);
        }
        ans = count;
        // 2.窗口按步长滑动 [0,3,5,6,7] => [3,5,6,7,9]
        // [0,3,5,6,7] => (3-0-1)*1 + (5-3-1)*2 + (6-5-1)*2 + (7-6-1)*1 = 4
        // [3,5,6,7,9] =>             (5-3-1)*1 + (6-5-1)*2 + (7-6-1)*2 + (9-7-1)*1 = 2
        // 通过对比发现：count -= (3-0-1)*1 + (5-3-1)*1 + (6-5-1)*0 = 3 - 0 + 5 - 3 + 1 + 1= 5 - 0 + 2
        //             count += (7-6-1)*1 + (9-7-1)*1 = 7 - 6 + 9 - 7 - 1 - 1 = 9 - 6 - 2
        // 类似于差分和前缀和的关系，加减2相互抵消，所以最后结果与窗口内两端点和中位数有关
        for (int i = k; i < index; i++) {
            count -= pos[i - k + mid] - pos[i - k]; // 上个区间中位数下标 - 上个区间左端点
            count += pos[i] - pos[i - mid]; // 当前区间右端点 - 当前区间中位数
            ans = Math.min(ans, count);
        }
        return ans;
    }

}
