import java.util.Arrays;

public class maxHappyGroups1815 {
    public static void main(String[] args) {
        System.out.println(new maxHappyGroups1815().maxHappyGroups(4,new int[]{1,3,2,5,2,2,1,6}));
    }

    public int maxHappyGroups(int batchSize, int[] groups) {
        //如果batchSize==3，那么只有两种需要比较的,但是由于为了简便判断这里将其设置为batchSize
        int[] numberCount = new int[batchSize];
        Arrays.fill(numberCount, 0);
        for (int number : groups) {
            numberCount[number % batchSize]++;
        }
        int res = numberCount[0];
        for (int i = 1; i <= numberCount.length / 2; i++) {
            int first = numberCount[i];
            int second = numberCount[batchSize - i];
            int min = Math.min(first, second);
            res += min;
            numberCount[i] -= min;
            numberCount[batchSize - i] -= min;
        }
        for (int i = 1; i < numberCount.length; i++) {
            int number = numberCount[i];
            if (number != 0) {
                int magnification = 2;
                int temp = i * 2;
                while (temp % batchSize != 0) {
                    magnification++;
                    temp += i;
                }
                int m = numberCount[i] / magnification;
                res += m;
            }
        }
        return res;
    }
}
