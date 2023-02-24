import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class minimumOperations2357 {
    public int minimumOperations(int[] nums) {
        //默认是小顶堆
        int count = 0;
        int res = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (num != 0) {
                hashSet.add(num);
            }
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(hashSet);
        while (!priorityQueue.isEmpty()) {
            int min = priorityQueue.poll();
            if (min - count <= 0) {
                break;
            }
            count += (min - count);//注意这里是要加上(min - count)而不是min
            res++;
        }
        return res;
    }
}
