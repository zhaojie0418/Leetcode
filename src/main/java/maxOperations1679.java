import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class maxOperations1679 {
    public static void main(String[] args) {

    }
    //双指针凑出来对应的目标数，根据凑出来的结果和目标数比较来判断指针移动的方向
    public int maxOperations(int[] nums, int k) {
        int result = 0;
        //排序
        //注意使用双指针排序方法需要首先对其进行排序
        Arrays.sort(nums);
        //头尾指针
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (k == sum) {//刚好相等。两个指针都往中间移动
                result++;
                i++;
                j--;
            } else if (k > sum) {//两数之和太小，左指针右移，让和变大
                i++;
            } else {//两数之和太大，右指针左移，让和变小
                j--;
            }
        }
        return result;
    }
    //使用hashMap进行存储并判断
    public int maxOperations2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int result = 0;
        //统计每个数据出现的次数，key为数据，value为次数
        for (int num : nums) {
            // 获取求和的另一个数
            int x = k - num;
            // 从map获取x
            Integer i = map.get(x);
            // 是否有 另一个数据。且统计的数量大于0
            if (i != null && map.get(x) > 0) {
                result++;//结果+1
                map.put(x, map.get(x) - 1);// 数量减一
                continue;
            }
            //这个数没有被使用，统计数量+1
            Integer count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        return result;
    }

    //实际上还可以使用数组定位统计法
    //数组定位统计法：类似ascll码作为角标，空间换时间，但是数据太大太夸张
}
