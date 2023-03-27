package meituan0325;

import java.util.HashSet;
import java.util.Scanner;

public class candy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int chetCount = sc.nextInt();
        int[] candyAll = new int[count];
        sc.nextLine();
        for(int i = 0; i < count; i++){
            candyAll[i] = sc.nextInt();
        }
        int res = maxCount(candyAll, count);
        System.out.println(res);
    }

    public static int maxCount(int[] candyAll,int length) {
        int[] dp = new int[length];
        dp[0] = candyAll[0];
        for (int i = 1; i < length; i++) {
            int nowCandy = candyAll[i];
            if (i - 3 >= 0 && dp[i - 3] + nowCandy > dp[i - 1]) {
                dp[i] = dp[i - 3] + nowCandy;
            } else {
                dp[i] =dp[i - 1];
            }
        }
        return dp[length - 1];
    }
}
