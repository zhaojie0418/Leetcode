package interviewGroup.xiaohongshu0326;

import java.util.*;

public class makeNumber {
    public static void main(String[] args) {
        //这边考虑等号之前的与或操作都可以省略
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] data = new int[length];
        for (int i = 0; i < length; i++) {
            data[i] = sc.nextInt();
        }
        int actCount = sc.nextInt();
        int[] leftIndex = new int[actCount];
        int[] rightIndex = new int[actCount];
        String action;
        int[] actNumber = new int[actCount];
        for (int i = 0; i < actCount; i++) {
            leftIndex[i] = sc.nextInt();
        }
        for (int i = 0; i < actCount; i++) {
            rightIndex[i] = sc.nextInt();
        }
        sc.nextLine();
        action = sc.nextLine();
        for (int i = 0; i < actCount; i++) {
            actNumber[i] = sc.nextInt();
        }
        HashMap<Integer, HashSet<Integer>> hashMap = new HashMap<>();
        //处理action
        for (int i = actCount - 1; i >= 0;) {
            char mod = action.charAt(i);
            if (mod == '=') {
                int left = leftIndex[i] - 1;
                int right = rightIndex[i] - 1;
                HashSet<Integer> tempSet = new HashSet<>();
                for (; left <= right; left++) {
                    tempSet.add(left);
                }
                i--;
                if (i < 0) {
                    break;
                }
                char preMod = action.charAt(i);
                while (preMod != '=') {
                    hashMap.put(i, tempSet);
                    i--;
                    if (i >= 0) {
                        preMod = action.charAt(i);
                    }
                }
            } else {
                i--;
            }
        }
        for (int i = 0; i < action.length(); i++) {
            char mod = action.charAt(i);
            int left = leftIndex[i]-1;
            int right = rightIndex[i]-1;
            int number = actNumber[i];
            HashSet<Integer> noNumber = hashMap.getOrDefault(i, null);
            if (mod == '=') {
                for (; left <= right; left++) {
                    data[left] = number;
                }
            } else if (mod == '|') {
                for (; left <= right; left++) {
                    if (noNumber != null && noNumber.contains(left)) {
                        continue;
                    }
                    data[left] = data[left] | number;
                }
            } else {
                for (; left <= right; left++) {
                    if (noNumber != null && noNumber.contains(left)) {
                        continue;
                    }
                    data[left] = data[left] & number;
                }
            }
        }
        for (int i = 0; i < data.length - 1; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.print(data[data.length-1]);
    }
}
