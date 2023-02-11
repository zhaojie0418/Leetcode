package pointOffer;

import java.util.Arrays;

public class exchange21 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new exchange21().exchange(new int[]{1, 2, 3, 4})));
    }
    public int[] exchange(int[] nums) {
        int count = nums.length - 1;
        //这里考虑实际上只使用一个指针应该也可以的吧
        for (int i = 0; i < count; i++) {
            int num = nums[i];
            if ((num & 1) == 0) { //如果是偶数
                nums[i] = nums[count];
                nums[count] = num;
                count--;
                i--;//换过来的这个数也需要比较
            }
        }
        return nums;
    }
}
