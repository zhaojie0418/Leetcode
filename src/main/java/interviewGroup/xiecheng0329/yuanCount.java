package interviewGroup.xiecheng0329;

import java.util.Scanner;

public class yuanCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        int res = 0;
        for (int i = 0; i < data.length(); i++) {
            char temp = data.charAt(i);
            if (temp == '0'||temp == '6'||temp=='9') {
                res++;
            } else if (temp == '8') {
                res += 2;
            }
        }
        System.out.println(res);
    }
}
