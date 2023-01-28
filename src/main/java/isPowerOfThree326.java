public class isPowerOfThree326 {
    public static void main(String[] args) {
        System.out.println(new isPowerOfThree326().isPowerOfThree(27));
    }

    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        } else {
            int tempNumber = 1;
            while (tempNumber < n) {
                tempNumber *= 3;
            }
            if (tempNumber == n) {
                return true;
            } else {
                return false;
            }
        }
    }
    //倒着除来保证是约数
    public boolean isPowerOfThree2(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
    //在题目给定的 3232 位有符号整数的范围内，最大的 33 的幂为 3^{19} = 11622614673 的约数即可

    public boolean isPowerOfThree3(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

}
