package interviewGroup.xiaohongshu0326;

import java.util.Scanner;

public class hashCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        sc.nextLine();
        String data = sc.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = data.charAt(i);
            char temp = (char) (((c - 3 - 'a' + 26) % 26) +'a');
            stringBuilder.append(temp);
        }

        System.out.println(stringBuilder);
    }
}
