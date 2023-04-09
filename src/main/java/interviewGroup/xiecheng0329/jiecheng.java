package interviewGroup.xiecheng0329;

import java.util.HashMap;
import java.util.Scanner;

public class jiecheng {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //使用hashMap保留下递归过程中的x的阶乘
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 1);
        int x = 1;
        int temp = 2;
        int y = 1;
        int minBreak = Integer.MAX_VALUE;
        int resX = 1;
        int resY = 1;
        //计算得到最大的x
        while (x - 1 <= n) {
            x = x * temp;
            hashMap.put(temp, x);
            temp++;
        }
        temp -= 2;
        while (temp > 1) {
            if (temp == 2) {
                temp--;
                continue;
            }
            y = n / (hashMap.get(temp) - 1);
            int tempBreak = n - (hashMap.get(temp) - 1) * y;
            if (tempBreak < minBreak && y != 2) {
                minBreak = tempBreak;
                resX = temp;
                resY = y;
            }
            y++;
            tempBreak = (hashMap.get(temp) - 1) * y - n;
            if (tempBreak < minBreak && y != 2) {
                minBreak = tempBreak;
                resX = temp;
                resY = y;
            }
            temp--;
        }

        System.out.println(resX + " " + resY);
    }

}
