import java.util.HashMap;
import java.util.Optional;

public class longestArithSeqLength1027 {
    public static void main(String[] args) {
        new longestArithSeqLength1027().longestArithSeqLength(new int[]{83, 20, 17, 43, 52, 78, 68, 45});
    }
    public int longestArithSeqLength(int[] nums) {
        //使用等差数列作为分组
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int differ = nums[i] - nums[j];
                hashMap.put(differ, hashMap.getOrDefault(differ, 1) + 1);
            }
        }
        int max = Integer.MIN_VALUE;
        for (Integer i : hashMap.values()) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
