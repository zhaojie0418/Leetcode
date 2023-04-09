package interviewGroup.pdd;

import java.util.Scanner;

public class feiji {
    public static void main(String[] args) {
        //实际上只和一的数量有关
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dCount = sc.nextInt();
        int[] res = new int[n];
        int tmp;
        for(int i = 0; i < n; i++){
            int count1 = 0;
            for(int j = 0; j < dCount; j++){
                tmp = sc.nextInt();
                if (tmp == 1) {
                    count1++;
                }
            }
            res[i] = dCount - count1 / 2;
            System.out.println(res[i]);
        }

    }
}
