package meituan0325;

import java.util.*;

public class trainStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groupCount = sc.nextInt();
        int[] countChar = new int[groupCount];
        List<int[]> pushArray = new ArrayList<>();
        List<int[]> popArray = new ArrayList<>();
        for (int i = 0; i < groupCount; i++) {
            countChar[i] = sc.nextInt();
            int[] inArray = new int[countChar[i]];
            int[] outArray = new int[countChar[i]];
            for (int j = 0; j < countChar[i]; j++) {
                inArray[j] = sc.nextInt();
            }
            for (int j = 0; j < countChar[i]; j++) {
                outArray[j] = sc.nextInt();
            }
            pushArray.add(inArray);
            popArray.add(outArray);
        }
//        System.out.println(groupCount);
//        for (int i = 0; i < 3; i++) {
//            System.out.println(Arrays.toString(popArray.get(i)));
//        }
//        for (int i = 0; i < 3; i++) {
//            System.out.println(Arrays.toString(pushArray.get(i)));
//        }

        for (int i = 0; i < groupCount; i++) {
            boolean res = isRight(pushArray.get(i), popArray.get(i));
            if (res) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static boolean isRight(int[] inArray, int[] outArray) {
        int length = outArray.length;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < length; i++) {
            int pop = outArray[i];
            while (stack.isEmpty() || stack.peek() != pop) {
                if (index >= length) {
                    return false;
                }
                stack.push(inArray[index]);
                index++;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }
}
