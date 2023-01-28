import java.util.ArrayList;
import java.util.List;

public class findDisappearedNumbers448 {
    //利用原地哈希的算法，同时根据取模计算的特性能够保证在判断是否出现的前提同时不使用额外的空间
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}
