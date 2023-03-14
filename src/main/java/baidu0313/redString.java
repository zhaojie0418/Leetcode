package baidu0313;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class redString {
    //这里考虑只使用red这个序列
    public static void main(String[] args) {
        while (true) {
            StringBuilder stringBuilder = new StringBuilder();
            Scanner sc = new Scanner(System.in);
            int count = sc.nextInt();
            int[] countC = new int[3];
            char[] chars = {'r', 'e', 'd'};
            Arrays.fill(countC, 0);
            for (int i = 0; i < 3; i++) {
                int n = 1;
                //        int n = (int) Math.sqrt(2.0 * count);
                while (((1 + n) * n) / 2 < count) {
                    n++;
                }
                if (((1 + n) * n) / 2 == count) {
                    countC[i] = n;
                    break;
                }
                n--;
                countC[i] = n;
                count -= ((1 + n) * n) / 2;
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < countC[i]; j++) {
                    stringBuilder.append(chars[i]);
                }
            }
            System.out.println(stringBuilder);
        }
    }
}
