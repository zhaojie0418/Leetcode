import java.util.HashMap;
import java.util.Map;

public class checkSubarraySum523 {
    public static void main(String[] args) {
        System.out.println(new checkSubarraySum523().checkSubarraySum(new int[]{1, 0}, 2));
    }
    //这里转换思路需要判断对应数组之差
    //这里产生分歧的点在于0的分歧，单个0应该跳过，但是多个0则是正确的
    //上一条考虑失误，不能只考虑0的情况，准确来说应该是要排除单个数字就能使得整除的情况
    public boolean checkSubarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        if (nums.length <= 1) {
            return false;
        }
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);//没有任何前缀的时候即为零，易漏
        boolean zeroNext = false;
        for (int num : nums) {
            if (num == 0) {
                if (zeroNext) {
                    return true;
                }
                zeroNext = true;
                continue;
            }
            zeroNext = false;
            pre += num;
            int res = pre % k;//注意这里对于负数求余的修正
            if (mp.containsKey(res)) {
                return true;
            }
            //注意这里需要先判断后再放进hashMap
            //并且这里不能使用hashSet进行，因为有负数的存在，所以可能相同数字会有多种情况（+1又-1，和前两个前缀一样，但是不同种）
            mp.put(res, mp.getOrDefault(res, 0) + 1);
        }
        return false;
    }
    //正确做法应该对index进行处理判断
    public boolean checkSubarraySum2(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);//这个实际上不存在的0的index应该是-1
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);//存放的value是对应的余数对应的index
                //（这里不用担心覆盖的问题）因为实际上只是为了判断是否是单个，而覆盖掉的也是最短的
            }
        }
        return false;
    }

}
