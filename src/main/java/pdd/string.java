package pdd;

import java.util.Scanner;

public class string {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = 0;
            while (c >= '0' && c <= '9') {
                count = count * 10 + c - '0';
                i++;
                c = s.charAt(i);
            }
            for (int j = 0; j < count; j++) {
                res.append(c);
            }
        }
        System.out.println(res);
    }
}
