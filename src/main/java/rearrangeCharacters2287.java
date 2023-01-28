import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class rearrangeCharacters2287 {
    public int rearrangeCharacters(String s, String target) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        int[] arr = new int[26];
        Arrays.fill(arr, 0);
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - 'a';
            arr[temp]++;
        }
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            char c = (char) (i + 'a');
            if (hashMap.containsKey(c)) {
                int count = arr[i] / hashMap.get(c);
                if (count < minCount) {
                    minCount = count;
                }
            }

        }
        return minCount;
    }
}
