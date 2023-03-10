import java.util.HashMap;

public class subarraysDivByK974 {
    public static void main(String[] args) {
        System.out.println(new subarraysDivByK974().subarraysDivByK(new int[]{-1,2,9}, 2));
    }
    //注意这里需要返回的是对应的数目
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);//没有任何前缀的时候即为零，易漏
        for (int num : nums) {
            pre += num;
            int res = (pre % k + k) % k;//注意这里对于负数求余的修正
            if (mp.containsKey(res)) {
                count += mp.get(res);
            }
            //注意这里需要先判断后再放进hashMap
            //并且这里不能使用hashSet进行，因为有负数的存在，所以可能相同数字会有多种情况（+1又-1，和前两个前缀一样，但是不同种）
            mp.put(res, mp.getOrDefault(res, 0) + 1);
        }
        return count;
    }
}
