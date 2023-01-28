public class nthUglyNumber264 {
    public static void main(String[] args) {
        System.out.println(new isUgly263().isUgly(1));
    }
    public int nthUglyNumber(int n) {
        int number = 1;
        while(n != 0){
            if(isUgly(number)){
                n--;
            }
            number++;
        }

        return number-1;
    }

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
