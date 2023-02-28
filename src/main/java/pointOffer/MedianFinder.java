package pointOffer;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    Queue<Integer> A, B;
    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }
    public void addNum(int num) {
        //说明现在是奇数
        //实际上这样操作就把中间那个元素一直推过来推过去
        if(A.size() != B.size()) {
            //往A中添加了一个，然后又从A中弹一个给B，相当于只有B增加了
            A.add(num);
            B.add(A.poll());
        } else {//说明现在是偶数
            //往B中添加了一个，然后又从B中弹一个给A，相当于只有A增加了
            B.add(num);
            A.add(B.poll());
        }
    }
    public double findMedian() {
        //判断奇数偶数中位数计算
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}
