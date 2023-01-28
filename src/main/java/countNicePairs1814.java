import java.util.HashMap;

public class countNicePairs1814 {
    public static void main(String[] args) {
        int res = new countNicePairs1814().countNicePairs(new int[]{13,10,35,24,76});
        System.out.println(res);
    }
    public int countNicePairs(int[] nums) {
        //利用hashMap减少遍历
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        long count = 0L;
        final int MOD = 1000000007;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int temp = num, j = 0;
            while (temp > 0) {
                j = j * 10 + temp % 10;
                temp /= 10;
            }
            num = num - j;
//            StringBuilder stringBuilder = new StringBuilder(Integer.toString(num));
//            num = num - Integer.parseInt(String.valueOf(stringBuilder.reverse()));
            count = (count + hashMap.getOrDefault(num, 0))%MOD;
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        return (int) (count%MOD);
    }
}
