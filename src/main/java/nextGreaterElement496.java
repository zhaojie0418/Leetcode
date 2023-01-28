import java.util.*;

public class nextGreaterElement496 {
    public static void main(String[] args) {
        int[] arr1 = {4,1,2};
        int[] arr2 = {1, 3, 4, 2};

        System.out.println(Arrays.toString(new nextGreaterElement496().nextGreaterElement(arr1, arr2)));
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        List<Integer> waitList = new ArrayList<>();
        HashMap<Integer, Integer> maxMap = new HashMap<>();
        for (int cur : nums2) {
            Deque<Integer> removeList = new ArrayDeque<>();
            for (int j = 0; j < waitList.size(); j++) {
                if (cur > waitList.get(j)) {
                    maxMap.put(waitList.get(j), cur);
                    removeList.add(waitList.get(j));
                }
            }
            while (!removeList.isEmpty()) {
                waitList.remove(removeList.pop());
            }
            waitList.add(cur);
        }
        for (int i : waitList) {
            maxMap.put(i, -1);
        }
        int length = nums1.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = maxMap.get(nums1[i]);
        }
        return res;
    }
}
