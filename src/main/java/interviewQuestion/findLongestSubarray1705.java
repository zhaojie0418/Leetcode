package interviewQuestion;

import java.util.Arrays;
import java.util.HashMap;

public class findLongestSubarray1705 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new findLongestSubarray1705().findLongestSubarray(new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"})));
    }
    //这里尝试使用前缀和处理
    public String[] findLongestSubarray(String[] array) {
        int length = array.length;
        int count = 0;
        int res = 0;
        int resI = Integer.MAX_VALUE, resJ = Integer.MAX_VALUE;//需要返回的还是最长子数组，只要保证返回的是最左边的即可
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);
        for (int i = 0; i < length; i++) {
            char s = array[i].charAt(0);
            if (s >= '0' && s <= '9') {
                count++;
            } else {
                count--;
            }
            if (hashMap.containsKey(count)) {
                int j = hashMap.get(count);
                if (i - j > resI-resJ) {//注意这里相等的时候不能处理
                    resI = i;
                    resJ = j;
                }
            } else {
                hashMap.put(count, i);
            }
        }
        if (resJ == Integer.MAX_VALUE) {
            return new String[]{};
        } else {
            String[] result = new String[resI - resJ];
            for (int i = resJ + 1; i <= resI; i++) {
                result[i - resJ - 1] = array[i];
            }
            return result;
        }
    }
}
