package pointOffer;

import java.util.HashSet;

public class isStraight61 {
    public boolean isStraight(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num == 0) continue;
            if (set.contains(num)) return false;
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return max - min <= 4;
    }
}
