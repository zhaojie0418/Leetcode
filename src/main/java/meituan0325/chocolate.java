package meituan0325;

import java.util.Arrays;
import java.util.Scanner;

public class chocolate {
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
        int length = chocolateAll.length;
        int[][] dp = new int[length + 1][bagCount + 1];
        for (int i = 1; i <= length; i++) {
            int lastChocolate = chocolateAll[i - 1];
            for (int j = 1; j <= bagCount; j++) {
                if (j < lastChocolate) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - lastChocolate] + 1);
                }
            }
        }
        return dp[length][bagCount];
    }

}
