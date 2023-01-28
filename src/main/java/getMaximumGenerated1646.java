public class getMaximumGenerated1646 {
    public int getMaximumGenerated(int n) {
        int[] arr = new int[n + 1];
        if (n <= 1) {
            return n;
        }
        arr[0] = 0;
        arr[1] = 1;
        int max = 1;
        for (int i = 2; i < n + 1; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i / 2];
            } else {
                arr[i] = arr[(i - 1) / 2] + arr[((i - 1) / 2) + 1];
            }
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
