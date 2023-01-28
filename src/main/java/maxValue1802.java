public class maxValue1802 {
    public static void main(String[] args) {
        System.out.println(new maxValue1802().maxValue(6,1,10));
    }
    public int maxValue(int n, int index, int maxSum) {
        int maxIndex = 1;
        int sum = n;
        while (sum < maxSum) {
            sum = ++maxIndex;
            for (int i = index - 1,temp = maxIndex; i >= 0; i--) {
                //控制最多只能减少到1
                if (temp != 1) {
                    temp--;
                }
                sum += temp;
            }
            for (int i = index + 1,temp = maxIndex; i < n; i++) {
                //控制最多只能减少到1
                if (temp != 1) {
                    temp--;
                }
                sum += temp;
            }
        }
        return sum == maxSum ? maxIndex : maxIndex - 1;
    }
}
