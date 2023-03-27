package tengxun0326;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class stringCount {
    static String[] strings;
    static int stringCount;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        stringCount = sc.nextInt();
        sc.nextLine();
        strings = new String[stringCount];
        for (int i = 0; i < stringCount; i++) {
            String temp = sc.nextLine();
            HashSet<Character> hashSet = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < temp.length(); j++) {
                char c = temp.charAt(j);
                if (hashSet.contains(c)) {
                    continue;
                } else {
                    sb.append(c);
                    hashSet.add(c);
                }
            }
            strings[i] = sb.toString();
        }
        int res = 0;

        for (int i = 0; i < strings[0].length(); i++) {
            HashSet<Character> hashSet = new HashSet<>();
            res += dfs(i, 0, hashSet);
        }
        System.out.println(Arrays.toString(strings));
        System.out.println(res);

    }

    public static int dfs(int index, int level, HashSet<Character> hashSet) {
        char c = strings[level].charAt(index);
        if (hashSet.contains(c)) {
            return 0;
        }
        hashSet.add(c);
        if (level == stringCount - 1) {
            return 1;
        }
        int length = strings[level + 1].length();
        int res = 0;
        for (int i = 0; i < length; i++) {
            HashSet<Character> tempSet = new HashSet<>(hashSet);
            res += dfs(i, level + 1, tempSet);
        }
        return res;
    }
}
