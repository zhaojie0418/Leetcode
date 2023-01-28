import java.util.*;

public class kthDistinct2053 {
    public static void main(String[] args) {
        new kthDistinct2053().kthDistinct(new String[]{"d", "b", "c", "b", "c", "a"}, 2);
    }
    public String kthDistinct(String[] arr, int k) {
        int length = arr.length;
        if (k > length) {
            return "";
        }
        HashMap<String, Integer> hashMap = new LinkedHashMap<>();
        for (String s : arr) {
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry: hashMap.entrySet()){
            if (entry.getValue() == 1) {
                k--;
                if (k == 0) {
                    return entry.getKey();
                }
            }
        }
        return "";
    }
}
