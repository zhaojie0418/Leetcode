package baidu0313;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class baiduString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String[] strings = new String[count];
        sc.nextLine();
        for(int i = 0; i < count; i++){
            strings[i] = sc.nextLine();
        }
        for (String s : strings) {
            HashSet<Character> hashSet = new HashSet<>();
            int length = s.length();
            if (length < 5) {
                System.out.println("No");
                continue;
            }
            for (int i = 0; i < length; i++) {
                hashSet.add(s.charAt(i));
            }
            if (hashSet.contains('B') && hashSet.contains('a') && hashSet.contains('i') && hashSet.contains('d') && hashSet.contains('u')) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

    }
}
