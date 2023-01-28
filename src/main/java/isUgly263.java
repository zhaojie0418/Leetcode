public class isUgly263 {
    //一个数的质因数包含2,3,5 的数称之为丑数，换言之，任何一个丑数都可以用2,3,5 的幂组成
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}
