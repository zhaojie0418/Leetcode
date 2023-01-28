public class findDuplicate287 {
    //每次进行二分，对中间的数遍历整个链表，统计小于等于中间这个数的数量，如果这个数量大于本身这个数值，说明这个数在左边，反之在右边
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    //官方解法：对于重复出现的元素，其性质在于一定有两个数字指向这个重复的数字，即如果每一次都使得其转到下一个元素一定会存在环
/*
    第三种解法想到了，但做得时候发现由于存在不包含重复数字的环，用快慢指针也没法没法从这种情况跳出去，所以一开始看第三种解法感觉是错的，但拿标答提交了一下通过了，差点让我怀疑人生

    后来仔细思考了之后发现由于数字从1开始计数，0这个位置不可能被其它位置的数字指向，所以0位置不可能在环内，所以从0开始遍历一定会指向某个包含重复数字的环，

    这么重要的事情答案居然一点都没提。。

    这个题还可以再改改，比如数字从0计数到n-1，那就得从n开始遍历了，少了哪个数就从哪开始遍历
    */
    public int findDuplicate2(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
