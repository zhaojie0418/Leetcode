package interviewGroup.meituan0325;

import java.util.Arrays;
import java.util.Scanner;

public class c2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chocolateCount = sc.nextInt();
        int queryCount = sc.nextInt();
        int[] chocolateAll = new int[chocolateCount];
        Arrays.sort(chocolateAll);
        int[] queryAll = new int[queryCount];
        sc.nextLine();
        for (int i = 0; i < chocolateCount; i++) {
            int temp = sc.nextInt();
            chocolateAll[i] = temp * temp;
        }
        for (int i = 0; i < queryCount; i++) {
            queryAll[i] = sc.nextInt();
        }
        for (int i = 0; i < queryCount - 1; i++) {
            int res = maxCount(chocolateAll, queryAll[i]);
            System.out.print(res + " ");
        }
        int res = maxCount(chocolateAll, queryAll[queryCount-1]);
        System.out.print(res);
    }

    public static int maxCount(int[] chocolateAll,int bagCount) {
        int count = 0;
        int length = chocolateAll.length;
        for (int j : chocolateAll) {
            if (j <= bagCount) {
                count++;
                bagCount -= j;
            } else {
                break;
            }
        }
        return count;
    }

}
