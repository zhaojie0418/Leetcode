import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class getDistances2121 {
    public long[] getDistances(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            } else {
                map.put(arr[i],new ArrayList<>());
                map.get(arr[i]).add(i);
            }
        }

        return new long[0];
    }
}
