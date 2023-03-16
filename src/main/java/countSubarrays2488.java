import java.util.HashMap;
import java.util.Map;

public class countSubarrays2488 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 4, 3, 6};
        int k = 1;
        System.out.println(new countSubarrays2488().countSubarrays(arr, k));
    }
    public int countSubarrays(int[] nums, int k) {
        //滑动窗口的右边至少要在给定k的前面，滑动窗口的左边至少要在给定的左边
        //这里考虑不去计算真正的中位数，只记录大于k的数量和小于k的数量
        //前缀和+hash
        //实际上可以先通过遍历一遍来确定对应的k位置，这里尝试是否可以不先遍历一遍就执行
        int res = 0;
        int pre = 0;
        //还没有遇到k时，只放不检测
        boolean putOrTest = true;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > k) {
                pre--;
            } else if (nums[i] < k) {
                pre++;
            }else {
                putOrTest = false;
            }

            if (putOrTest) {
                hashMap.put(pre, hashMap.getOrDefault(pre, 0) + 1);
            } else {
                if (hashMap.containsKey(pre)) {
                    int count = hashMap.get(pre);
                    res += count;
                }
                if (hashMap.containsKey(pre + 1)) {
                    int count = hashMap.get(pre + 1);
                    res += count;
                }
                if (nums[i] == k) {
                    hashMap.put(pre, hashMap.getOrDefault(pre, 0) + 1);
                }
            }
        }
        return res;
    }

    public int countSubarrays2(int[] nums, int k) {
        int n = nums.length;
        int kIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                kIndex = i;
                break;
            }
        }
        int ans = 0;
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        counts.put(0, 1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sign(nums[i] - k);
            if (i < kIndex) {
                counts.put(sum, counts.getOrDefault(sum, 0) + 1);
            } else {
                int prev0 = counts.getOrDefault(sum, 0);
                int prev1 = counts.getOrDefault(sum - 1, 0);
                ans += prev0 + prev1;
            }
        }
        return ans;
    }

    public int sign(int num) {
        if (num == 0) {
            return 0;
        }
        return num > 0 ? 1 : -1;
    }
}
