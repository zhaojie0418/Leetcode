package interviewGroup.hengsheng0331;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class waterfloor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        int n = 10000;
        List<Integer> res = new ArrayList<>();
        for (int i = 11; i < n; i++) {
            if (isGoodNumber(i)) {
                res.add(i);
            }
        }
        for (int i = res.size() - 1; i >= 0; i--) {
            System.out.println(res.get(i));
        }
    }

    public static boolean isGoodNumber(int num) {
        String s = Integer.toString(num);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - '0';
            sum += Math.pow(temp, s.length());
        }
        return sum == num;
    }
}
