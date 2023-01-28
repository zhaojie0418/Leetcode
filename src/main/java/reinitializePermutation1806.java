public class reinitializePermutation1806 {
    public static void main(String[] args) {
        int res = new reinitializePermutation1806().reinitializePermutation(4);
        System.out.println(res);
    }
    public int reinitializePermutation(int n) {
        if (n == 2) return 1;
        int count = 1;
        int max = n - 1;
        boolean isAll = false;
        //初始化数组
        int[] arr = new int[n-2];
        int[] numbers = new int[n-2];
        for (int i = 0; i < n - 2; i++) {
            arr[i] = i + 1;
            numbers[i] = i + 1;
        }
        while (!isAll) {
            isAll = true;
            count++;
            for (int i = 0; i < n - 2; i++) {
                arr[i] = (arr[i] * 2) % max;
                numbers[i] = numbers[i] + arr[i];
                if (numbers[i] % max != 0) {
                    isAll = false;
                }
            }

        }
        return count;
    }
}
