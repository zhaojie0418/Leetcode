package interviewGroup.xiecheng0329;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class inputTest {
    static int max = 0;
    static List<int[]> list = new ArrayList<>();
    static int count = 0;
    public static void main(String[] args) {
        int nodeCount = 5;
        count = 4;
        list.add(new int[]{1, 2, 2});
        list.add(new int[]{2, 3, 5});
        list.add(new int[]{3, 4, 4});
        list.add(new int[]{3, 5, 3});

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
            goGet(i+1, hashSet, tempSum);
        } else {
            hashSet.add(tempArr[0]);
            hashSet.add(tempArr[1]);
            goGet(i, hashSet, tempSum + tempArr[2]);
        }
    }
}
