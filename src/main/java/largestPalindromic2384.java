import java.util.Arrays;

public class largestPalindromic2384 {
    public static void main(String[] args) {
        System.out.println(new largestPalindromic2384().largestPalindromic("444947137"));
    }
    public String largestPalindromic(String num) {
        int[] numbers = new int[10];
        Arrays.fill(numbers, 0);
        for (int i = 0; i < num.length(); i++) {
            numbers[num.charAt(i) - '0']++;
        }
        StringBuilder sb1 = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (i == 0 && sb1.length() == 0) {
                break;
            }
            while (numbers[i] > 1) {
                sb1.append(i);
                numbers[i] -= 2;
            }
        }
//        StringBuilder sb2 = sb1.reverse();
        StringBuilder sb2 = new StringBuilder(sb1).reverse();
        for (int i = 9; i >= 0; i--) {
            if (numbers[i] == 1) {
                sb1.append(i);
                break;
            }
        }
        sb1.append(sb2);

        return sb1.length()==0 ? "0":sb1.toString();
    }
}

