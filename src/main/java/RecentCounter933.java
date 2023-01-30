import java.util.ArrayDeque;
import java.util.Queue;

public class RecentCounter933 {
    Queue<Integer> queue;

    public RecentCounter933() {
        queue = new ArrayDeque<Integer>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
