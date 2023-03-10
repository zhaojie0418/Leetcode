import java.util.HashMap;

public class findMaxLength525 {
    public int findMaxLength(int[] nums) {
        //这里很巧妙的是每次遇到1就+1而遇到0是-1而不是不改
        //如果只记录的是1的数量则还需要进一步比对i和j对于1的数量关系，同时出现自变量和因变量，无法通过哈希表优化
        int length = nums.length;
        int count = 0;
        int res = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);//没有任何前缀的时候即为零，易漏
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (num == 1) {
                count++;
            } else {
                count--;
            }
            if (mp.containsKey(count)) {
                int j = mp.get(count);
                res = Math.max(res, i - j);
            } else {
                //放的时候放置的是count值对应的index
                //这里很巧妙的使用的只有不存在的时候才put，保证了对应的count是最左边的count
                mp.put(count, i);
            }
        }
        return res;
    }
}
