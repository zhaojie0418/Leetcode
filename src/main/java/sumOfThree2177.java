public class sumOfThree2177 {
    public long[] sumOfThree(long num) {
        if (num % 3 == 0) {
            long temp = num / 3;
            return new long[]{temp - 1, temp, temp + 1};
        } else {
            return new long[0];
        }

    }
}
