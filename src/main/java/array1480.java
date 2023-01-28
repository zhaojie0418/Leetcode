import java.lang.reflect.Array;
import java.util.Arrays;

public class array1480 {

    public static void main(String[] args) {

        int[] a = {1,2,3,4,5};
        int[] b = runningSum(a);
        System.out.println(Arrays.toString(b));
    }
    public static int[] runningSum(int[] nums) {
        for(int i=1;i<nums.length;i++)
            nums[i]=nums[i]+nums[i-1];
        return nums;
    }
}
