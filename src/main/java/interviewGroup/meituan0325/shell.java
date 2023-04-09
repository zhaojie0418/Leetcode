package interviewGroup.meituan0325;

import java.util.HashMap;
import java.util.Scanner;

public class shell {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        int keyCount = sc.nextInt();
        String[] keys = new String[keyCount];
        sc.nextLine();
        for (int i = 0; i < keyCount; i++) {
            keys[i] = sc.nextLine();
        }
//        System.out.println(Arrays.toString(keys));
        HashMap<String, String> hashMap = new HashMap<>();
        //添加数据
        String[] keyValue = data.split("[;=]");
        for (int i = 0; i < keyValue.length; i = i + 2) {
            String key = keyValue[i];
            String value = keyValue[i + 1];
            hashMap.put(key, value);
        }
        //检索数据
        for (int i = 0; i < keyCount; i++) {
            String res = hashMap.getOrDefault(keys[i], "EMPTY");
            System.out.println(res);
        }

    }
}
