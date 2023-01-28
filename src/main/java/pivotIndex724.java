import java.util.*;

public class pivotIndex724 {

    public static void main(String[] args) {
        int[] a = {3,7,5,9,4,5,6};
        System.out.println(pivotIndex(a));
    }

    public static int pivotIndex(int[] nums) {
        //如果直接传递则为引用传递，需要使用clone才是值传递
        int[] copyofnums = nums.clone();
        System.out.println(Arrays.toString(copyofnums));
        //length是实际上有多少个元素，而不是下标
        for(int i=1;i<nums.length;i++)
            nums[i]=nums[i]+nums[i-1];
        PriorityQueue<Integer> indexList = new PriorityQueue<>();
        int length = nums.length;
        for (int i =0;i<length;i++){
            if(nums[i]-copyofnums[i]==nums[length-1]-nums[i])
                indexList.add(i);
        }
        if (indexList.isEmpty())
            return -1;
        return indexList.poll();
    }
    //官方题解，思路相同只是在累加array的时候就进行判断了，减少判断量
    public int pivotIndex2(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

}
