package LCP;

import java.util.Comparator;
import java.util.PriorityQueue;

public class storeWater {
    public static void main(String[] args) {
        int[] bucket = {9,0,1};
        int[] vat = {0,2,2};
        System.out.println(new storeWater().storeWater(bucket, vat));
    }
    public int storeWater(int[] bucket, int[] vat) {
        int n = bucket.length;
        if (n <= 1) {
            if (bucket[0] != 0) {
                return (int) Math.ceil((double) vat[0] / bucket[0]);
            } else {
//                return
            }
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });
        for (int i = 0; i < n; i++) {
            priorityQueue.add(new int[]{bucket[i], vat[i], (int) Math.ceil((double) vat[i] / bucket[i])});
        }
        int addCount = 0;
        int putCount = 0;
        boolean better = true;
        while (better) {
            int[] maxNeed = priorityQueue.poll();
            int preNeed = maxNeed[2];
            int nowNeed = priorityQueue.peek()[2];
            maxNeed[0] += 1;
            maxNeed[2] = (int) Math.ceil((double) maxNeed[1] / maxNeed[0]);
            if (preNeed > Math.max(nowNeed, maxNeed[2])) {
                addCount++;
                priorityQueue.add(maxNeed);
            } else {
                putCount = preNeed;
                better = false;
            }
        }
        return addCount + putCount;
    }
}
