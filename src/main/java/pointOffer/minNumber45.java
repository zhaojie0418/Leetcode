package pointOffer;

import java.util.Arrays;
import java.util.Comparator;

public class minNumber45 {
    public String minNumber(int[] nums) {
        //题目限定是非负整数
        int length = nums.length;
        String[] strings = new String[length];
        for (int i = 0; i < length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(strings[i]);
        }
        return stringBuilder.toString();
    }
}
