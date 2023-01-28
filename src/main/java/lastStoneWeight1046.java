import java.util.Comparator;
import java.util.PriorityQueue;

public class lastStoneWeight1046 {
    public static void main(String[] args) {
        int[] arr = {2,7,4,1,8,1};
        System.out.println(new lastStoneWeight1046().lastStoneWeight(arr));
    }
    public int lastStoneWeight(int[] stones) {
        //使用优先队列并重写比较方法来构造出一个大顶堆，默认是小顶堆
        PriorityQueue<Integer> bigHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i : stones){
            bigHeap.add(i);
        }
        while(bigHeap.size()!=0&&bigHeap.size()!=1){
            int first  = bigHeap.poll();
            int second = bigHeap.poll();
            if(first == second){
                continue;
            }else {
                int res = first>second? first-second:second-first;
                bigHeap.add(res);
            }
        }
        if(bigHeap.isEmpty()){
            return 0;
        }else {
            return bigHeap.poll();
        }
    }
}
