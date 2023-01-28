public class largestOddNumber1903 {
    public static void main(String[] args) {
        new largestOddNumber1903().largestOddNumber("35267");
    }
    public String largestOddNumber(String num) {
        int length = num.length();
        String res = "";
        for (int i = length - 1; i >= 0; i--) {
            int temp = num.charAt(i) - '0';
            if (temp % 2 == 1) {
                res = num.substring(0, i + 1);
                break;
            }
        }
        return res;
    }
}
