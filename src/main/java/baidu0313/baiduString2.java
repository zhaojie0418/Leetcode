package baidu0313;

import java.util.HashSet;
import java.util.Scanner;

public class baiduString2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long count = sc.nextInt();
        sc.nextLine();
        for (int p = 0; p < count; p++) {
            String s = sc.nextLine();
            HashSet<Character> hashSet = new HashSet<>();
            int length = s.length();
            if (length != 5) {
                System.out.println("No");
                continue;
            }
            hashSet.add('B');
            hashSet.add('a');
            hashSet.add('i');
            hashSet.add('d');
            hashSet.add('u');
            for (int i = 0; i < length; i++) {
                hashSet.remove(s.charAt(i));
                if (hashSet.size() == 0) {
                    System.out.println("Yes");
                }
            }
            if (hashSet.size() == 0) {
                continue;
            }
            System.out.println("No");
        }

    }
}
