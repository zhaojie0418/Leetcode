import java.util.PriorityQueue;

public class halveArray2208 {
    public int halveArray(int[] nums) {
        double sum = 0;
        //注意最大堆构建
        PriorityQueue<Double> q = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        for (int nu : nums) {
            q.offer((double) nu);
            sum += (double) nu;
        }
        //这里的now是减去的部分
        double now = 0.0;
        int cnt = 0;
        while (now < sum * 0.5) {
            double head = q.poll();
            double half = head * 0.5;
            now += half;
            cnt++;
            q.offer(half);
        }
        return cnt;
    }
}
