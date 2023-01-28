import java.util.Comparator;
import java.util.PriorityQueue;

public class partitionDisjoint915 {
    public static void main(String[] args) {
        int[] arr = {5, 0, 3, 8, 3, 6};
        System.out.println(new partitionDisjoint915().partitionDisjoint2(arr));
    }
    //首先尝试使用堆操作，但是实际上堆操作消耗了太多的内存
    //尝试先遍历一遍，然后在遍历过程中维护右侧最大值
    //这里使用了两次遍历的方法
    public int partitionDisjoint(int[] nums) {
        int length = nums.length;
        int[] minRight = new int[length];
        int tempMin = nums[length - 1];
        for (int i = length - 1; i >= 0; i--) {
            tempMin = Math.min(tempMin, nums[i]);
            minRight[i] = tempMin;
        }
        int tempMax = nums[0];
        for (int i = 0; i < length - 1; i++) {
            tempMax = Math.max(tempMax, nums[i]);
            if (tempMax <= minRight[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }

    //这里使用的一次遍历的方式
    //curMax记录的是遍历过程中的整个最大的值
    //leftMax是分到左边队伍中的暂任最大值
    public int partitionDisjoint2(int[] nums) {
        int n = nums.length;
        int leftMax = nums[0], leftPos = 0, curMax = nums[0];
        for (int i = 1; i < n - 1; i++) {
            //当暂任最大值出现时，并不是这个最大值立马成为左边的领导
            //需要满足：1、curMax > leftMax 2、并且在更大值出现后又出现了比左边领导值小的数
            curMax = Math.max(curMax, nums[i]);
            if (nums[i] < leftMax) {
                leftMax = curMax;
                leftPos = i;
            }
        }
        return leftPos + 1;
    }

}
