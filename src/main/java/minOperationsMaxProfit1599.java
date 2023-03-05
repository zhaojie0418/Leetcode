public class minOperationsMaxProfit1599 {
    public static void main(String[] args) {
        int[] array = {8, 3};
        int b = 5;
        int r = 6;
        System.out.println(new minOperationsMaxProfit1599().minOperationsMaxProfit(array, b, r));
    }
    int humanCount = 0;
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        //注意这里需要输出的是达到最大利润时的次数而不是最大利润本身
        int temp = 0;
        int tempCount = 0;
        int res = 0;
        int resCount = 0;
        for (int customer : customers) {
            humanCount += customer;
            temp += takeCount() * boardingCost - runningCost;
            tempCount++;
            if (temp > res) {
                res = temp;
                resCount = tempCount;
            }
        }
        //这里注意判断如果剩下的人没办法使得其为正利润则可以不继续了，但是这里俺没有优化
        while (humanCount > 0) {
            temp += takeCount() * boardingCost - runningCost;
            tempCount++;
            if (temp > res) {
                res = temp;
                resCount = tempCount;
            }
        }
        return res > 0 ? resCount : -1;
    }

    public int takeCount() {
        int count = humanCount >= 4 ? 4 : humanCount % 4;
        humanCount -= count;
        return count;
    }
}
