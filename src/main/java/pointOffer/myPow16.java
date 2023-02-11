package pointOffer;

public class myPow16 {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
    public double quickMul(double x, long N) {
        double res = 1.0;
        double xTemp = x;
        while (N > 0) {
            if (N % 2 == 1) {
                res = res * xTemp;
            }
            xTemp = xTemp * xTemp;
            N = N / 2;
        }
        return res;
    }
}
