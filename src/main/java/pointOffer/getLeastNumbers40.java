package pointOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class getLeastNumbers40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
            if (i >= k) {
                pQ.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pQ.poll();
        }
        return res;
    }
}
