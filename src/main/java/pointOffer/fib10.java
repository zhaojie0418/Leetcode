package pointOffer;

public class fib10 {
    public static void main(String[] args) {
        System.out.println(new fib10().numWays(7));
    }
    final int MOD = 1000000007;
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        int c = a + b;
        n = n - 2;
        while (n != 0) {
            a = b;  //注意这里先对ab进行修改再计算
            b = c;
            c = (a + b) % MOD;
            n--;
        }
        return c % MOD;
    }

    public int numWays(int n) {
        if (n <= 3) {
            return n;
        }
        int a = 2, b = 3;
        int sum = a + b;
        n = n - 4;
        while (n != 0) {
            a = b;  //注意这里先对ab进行修改再计算
            b = sum;
            sum = (a + b) % MOD;
            n--;
        }
        return sum % MOD;
    }


}
