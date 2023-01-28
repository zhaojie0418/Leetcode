import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

public class minimumOperations2170 {
    public static void main(String[] args) {
        //System.out.println(new minimumOperations2170().minimumOperations(new int[]{48,38,42,18,13,1,97,88,82,48,54,16,78,59,52,30,40,77,59,87,71,28}));
        System.out.println(new minimumOperations2170().minimumOperations(new int[]{3,1,3,2,4,3}));
    }
    public int minimumOperations(int[] nums) {
        HashMap<Integer, Integer> hashMapA = new HashMap<>();
        HashMap<Integer, Integer> hashMapB = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            HashMap<Integer, Integer> tempHashMap;
            if (i % 2 == 0) {
                tempHashMap = hashMapA;
            } else {
                tempHashMap = hashMapB;
            }
            if (tempHashMap.containsKey(temp)) {
                tempHashMap.put(temp, tempHashMap.get(temp) + 1);
            } else {
                tempHashMap.put(temp, 1);
            }
        }
        int leftIndex = 0, rightIndex = 0;
        int leftIndex2 = 0, rightIndex2 = 0;
        boolean if_first = true;
        boolean if_second = true;
        for (Map.Entry<Integer, Integer> entry : hashMapA.entrySet()) {
            if (if_first) {
                leftIndex = entry.getKey();
                if_first = false;
                continue;
            }
            if (entry.getValue() >= hashMapA.get(leftIndex)) {
                leftIndex2 = leftIndex;
                leftIndex = entry.getKey();
            }
        }
        if_first = true;
        for (Map.Entry<Integer, Integer> entry : hashMapB.entrySet()) {
            if (if_first) {
                rightIndex = entry.getKey();
                if_first = false;
                continue;
            }
            if (entry.getValue() >= hashMapB.get(rightIndex)) {
                rightIndex2 = rightIndex;
                rightIndex = entry.getKey();
            }
        }
        int res;
        if (leftIndex == rightIndex) {
            res = nums.length - hashMapA.get(leftIndex) - Math.max(hashMapA.getOrDefault(leftIndex2,0),hashMapB.getOrDefault(rightIndex2,0) );
        } else {
            res = nums.length - hashMapA.get(leftIndex) - hashMapB.get(rightIndex);
        }
        return res;
    }
}
