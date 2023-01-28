import java.util.Arrays;

public class pivotArray2161 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new pivotArray2161().pivotArray(new int[]{19,15,12,-14,8,-7,-11}, -7)));

    }
    //首先想法是创建三个数组，但是这样对空间消耗大，所以使用双指针的方法
    public int[] pivotArray(int[] nums, int pivot) {
        int left = 0;
        int right = nums.length-1;
        //int[] res = new int[]{nums.length};
        int[] res = new int[nums.length];
//        Arrays.fill(res,0);
        int countZero = 0;
        for (int num : nums) {
            if (num > pivot) {
                res[right] = num;
                right--;
            } else if (num < pivot) {
                res[left] = num;
                left++;
            } else {
                countZero++;
            }
        }
        while (countZero != 0) {
            res[left] = pivot;
            left++;
            countZero--;
        }
        right = nums.length-1;
        for (int i = left; i < left + (nums.length - left) / 2; i++) {
            int temp = res[i];
            res[i] = res[right];
            res[right] = temp;
            right--;
        }
        return res;
    }
}
