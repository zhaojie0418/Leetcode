import java.util.HashMap;
import java.util.HashSet;

public class subarraySum560 {
    public static void main(String[] args) {
        System.out.println(new subarraySum560().subarraySum(new int[]{1}, 0));
    }
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);//没有任何前缀的时候即为零，易漏
        for (int num : nums) {
            pre += num;
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            //注意这里需要先判断后再放进hashMap
            //并且这里不能使用hashSet进行，因为有负数的存在，所以可能相同数字会有多种情况（+1又-1，和前两个前缀一样，但是不同种）
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

}
