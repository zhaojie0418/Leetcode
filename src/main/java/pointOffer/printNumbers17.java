package pointOffer;

public class printNumbers17 {
    public int[] printNumbers(int n) {
        int count = (int) (Math.pow(10, n) - 1);
        int[] res = new int[count];
        for (int i = 0; i < count; i++)
            res[i] = i + 1;
        return res;
    }
}
