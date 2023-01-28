public class minDays1482 {
    int n, m, k;
    boolean[] fl;
    public int minDays(int[] nums, int _m, int _k) {
        n = nums.length;
        m = _m; k = _k;

        if (n < m * k) return -1;

        fl = new boolean[n];

        int l = 0, r = (int)1e9;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(nums, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return check(nums, r) ? r : -1;
    }
    boolean check(int[] nums, int mid) {
        for (int i = 0; i < n; i++) {
            //如果当前传入的mid大于nums对应的num
            fl[i] = nums[i] <= mid;
        }
        int cnt = 0;
        for (int i = 0; i < n && cnt < m; ) {
            if (fl[i]) {
                int cur = 1, j = i;
                while (cur < k && j + 1 < n && fl[j + 1]) {
                    j++;
                    cur++;
                }
                if (cur == k) cnt++;
                i = j + 1;
            } else {
                i++;
            }
        }
        return cnt >= m;
    }
}
