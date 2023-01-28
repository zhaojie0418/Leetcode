import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class findingUsersActiveMinutes1817 {
    public static void main(String[] args) {

    }
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        //key值为ID，value为对应的分钟位置
        HashMap<Integer, HashSet<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            if (hashMap.containsKey(logs[i][0])) {
                HashSet<Integer> innerSet = hashMap.get(logs[i][0]);
                innerSet.add(logs[i][1]);
            } else {
                HashSet<Integer> newHashSet = new HashSet<>();
                newHashSet.add(logs[i][1]);
                hashMap.put(logs[i][0], newHashSet);
            }
        }

        int[] res = new int[k];
        Arrays.fill(res, 0);
        for (HashSet<Integer> temp : hashMap.values()) {
            res[temp.size() - 1]++;
        }
        return res;
    }
}
