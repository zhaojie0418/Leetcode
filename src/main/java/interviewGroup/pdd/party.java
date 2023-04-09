package interviewGroup.pdd;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class party {
    //先尝试用贪心思想
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //考虑优先安排必须要安排的
        String[] strings = new String[]{"A", "B", "C", "AB", "BC", "AC", "ABC"};
        int count = sc.nextInt();
        HashMap<String, Integer> hashMap = new HashMap<>();
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            String s = sc.nextLine();
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }
        int[] countMap = new int[3];
        int[] priceMap = new int[3];
        for (int i = 0; i < 3; i++) {
            countMap[i] = sc.nextInt();
            priceMap[i] = sc.nextInt();
        }
        int priceSum = 0;
        int countPeople = 0;
        boolean ifAvailable = true;
        for (int i = 0; i < 3; i++) {
            if (hashMap.containsKey(strings[i])) {
                int need = hashMap.get(strings[i]);
                if (need > countMap[i]) {
                    need = countMap[i];
                    ifAvailable = false;
                }
                countMap[i] -= need;
                countPeople += need;
                priceSum += priceMap[i] * need;
            }
        }
        if (ifAvailable) {
            System.out.println("YES");
            System.out.println(priceSum);
        } else {
            System.out.println("NO");
            System.out.println(countPeople);
        }
    }
}
