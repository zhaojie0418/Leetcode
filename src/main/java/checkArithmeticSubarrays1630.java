import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class checkArithmeticSubarrays1630 {
    public static void main(String[] args) {

    }
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = l.length;
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int left = l[i], right = r[i];
            //维护每次遍历过程中的最大值和最小值
            int minv = nums[left], maxv = nums[left];
            for (int j = left + 1; j <= right; ++j) {
                minv = Math.min(minv, nums[j]);
                maxv = Math.max(maxv, nums[j]);
            }
            //最大值和最小值相等则自然相同
            if (minv == maxv) {
                ans.add(true);
                continue;
            }
            //计算公差应该是一个正数
            if ((maxv - minv) % (right - left) != 0) {
                ans.add(false);
                continue;
            }

            int d = (maxv - minv) / (right - left);
            boolean flag = true;
            boolean[] seen = new boolean[right - left + 1];
            for (int j = left; j <= right; ++j) {
                if ((nums[j] - minv) % d != 0) {
                    flag = false;
                    break;
                }
                int t = (nums[j] - minv) / d;
                if (seen[t]) {
                    flag = false;
                    break;
                }
                seen[t] = true;
            }
            ans.add(flag);
        }
        return ans;
    }

}
