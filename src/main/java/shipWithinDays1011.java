import java.util.Arrays;

public class shipWithinDays1011 {
    public int shipWithinDays(int[] weights, int days) {
        // 确定二分查找左右边界
        //stream可以理解成是一种高级的迭代器能够对大量数据进行操作
        //左边界是所有货物中的最大值  右边界是所有货物的重量总和
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        //并不是进行算法直接得到需要运送的重量，而是通过二分查找，近似暴力的得到对应的运力
        while (left < right) {
            //mid实际上就是根据二分查找所得到的猜测的运输重量
            int mid = (left + right) / 2;
            // need 为需要运送的天数
            // cur 为当前这一天已经运送的包裹重量之和
            int need = 1, cur = 0;
            for (int weight : weights) {
                //如果装不下了，说明要到下一趟才能运输
                if (cur + weight > mid) {
                    ++need;
                    cur = 0;
                }
                //说明能够继续装配则继续
                cur += weight;
            }
            if (need <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


}
