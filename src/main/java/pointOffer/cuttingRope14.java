package pointOffer;

public class cuttingRope14 {
    public static void main(String[] args) {
        int res = new cuttingRope14().cuttingRope(10);
        System.out.println(res);
    }
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int count = n / 3;
        int temp = 3;
        for (int i = 1; i < count; i++) {
            temp *= 3;
        }
        int res = n % 3;
        switch (res) {
            case 1:
                temp = temp / 3 * 4;
                break;
            case 2:
                temp = temp * 2;
                break;
        }
        return temp;
    }
}
