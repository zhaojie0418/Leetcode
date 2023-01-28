public class getSmallestString1663 {
    public String getSmallestString(int n, int k) {
        if (n == 1) {
            return ((char) ('a' + k - 1)) + "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (k - 1 <= (n - 1) * 26) {
            stringBuilder.append('a');
            k--;
            n--;
        }
        if (k != n * 26) {
            stringBuilder.append((char) ('a' + k % 26 - 1));
            n--;
        }
        while (n > 0) {
            stringBuilder.append('z');
            n--;
        }
        return stringBuilder.toString();
    }
}
