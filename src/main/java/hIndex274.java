import java.util.Arrays;

public class hIndex274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length;
        for (int i = length - 1; i >= 0; i--) {
            if (length - i >= citations[i]) {
                return citations[i];
            }
        }
        return -1;
    }
}
