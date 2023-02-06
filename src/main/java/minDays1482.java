public class minDays1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        int count = bloomDay.length;
        if (count < m * k) {
            return -1;
        }

        return m;
    }
}
