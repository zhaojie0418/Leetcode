package interviewGroup.xiecheng0329;

import java.util.*;

public class maxRed {
    static int max = 0;
    static List<int[]> list = new ArrayList<>();
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodeCount = sc.nextInt();
        while (sc.hasNext()) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            int weight = sc.nextInt();
            list.add(new int[]{left, right, weight});
            count++;
        }
        //能加上去才新开一条，否则直接继续即可
        for (int i = 0; i < count; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            int[] temp = list.get(i);
            hashSet.add(temp[0]);
            hashSet.add(temp[1]);
            int tempSum = temp[2];
            goGet(i, hashSet, tempSum);
        }
        System.out.println(max);
    }

    public static void goGet(int i, HashSet<Integer> hashSet,int tempSum) {
        i++;
        if (i >= count) {
            max = Math.max(max, tempSum);
            return;
        }
        int[] tempArr = list.get(i);
        if (hashSet.contains(tempArr[0]) || hashSet.contains(tempArr[1])) {
            max = Math.max(max, tempSum);
        } else {
            hashSet.add(tempArr[0]);
            hashSet.add(tempArr[1]);
            max = Math.max(max, tempSum + tempArr[2]);
            goGet(i, hashSet, tempSum + tempArr[2]);
        }
    }
}
