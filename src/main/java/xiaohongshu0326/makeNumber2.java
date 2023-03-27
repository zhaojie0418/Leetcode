package xiaohongshu0326;

import java.util.Scanner;

public class makeNumber2 {
    public static void main(String[] args) {
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
        for (int i = 0; i < action.length(); i++) {
            char mod = action.charAt(i);
            int left = leftIndex[i]-1;
            int right = rightIndex[i]-1;
            int number = actNumber[i];
            if (mod == '=') {
                for (; left <= right; left++) {
                    data[left] = number;
                }
            } else if (mod == '|') {
                for (; left <= right; left++) {
                    data[left] = data[left] | number;
                }
            } else {
                for (; left <= right; left++) {
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