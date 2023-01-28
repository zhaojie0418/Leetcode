public class minOperations1658 {
    //双指针
    public int minOperations(int[] nums, int x) {
        int sum = 0, n = nums.length, right = n;
        //先判断从最后面往前递减能否找到答案
        while (right > 0 && sum + nums[right - 1] <= x) // 计算最长后缀
            sum += nums[--right];
        if (right == 0 && sum < x) return -1; // 全部移除也无法满足要求
        int ans = sum == x ? n - right : n + 1;
        for (int left = 0; left < n; ++left) {
            sum += nums[left];
            while (right < n && sum > x) // 缩小后缀长度
                sum -= nums[right++];
            if (sum > x) break; // 缩小失败，说明前缀过长
            if (sum == x) ans = Math.min(ans, left + 1 + n - right); // 前缀+后缀长度
        }
        return ans > n ? -1 : ans;
    }

    //逆向思路+双指针
    public int minOperations2(int[] nums, int x) {
        int target = -x;
        for (int num : nums) target += num;
        if (target < 0) return -1; // 全部移除也无法满足要求
        int ans = -1, left = 0, sum = 0, n = nums.length;
        for (int right = 0; right < n; ++right) {
            sum += nums[right];
            while (sum > target) sum -= nums[left++]; // 缩小子数组长度
            if (sum == target) ans = Math.max(ans, right - left + 1);
        }
        return ans < 0 ? -1 : n - ans;
    }
}
