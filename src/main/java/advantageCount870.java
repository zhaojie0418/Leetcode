import java.util.Arrays;
import java.util.Comparator;

public class advantageCount870 {
    public static void main(String[] args) {
        int[] arrA = new int[]{12, 24, 8, 32};
        int[] arrB = new int[]{13,25,32,11};
        System.out.println(Arrays.toString(new advantageCount870().advantageCount(arrA, arrB)));
    }
    //这个地方实际上是不能对这个num2进行排序的，因为这样会使得num2的序列被打乱，所以我们需要记住这个数组，更准确的说，应该记住这个数组的“序列”
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int indexA = 0;
        int length = nums1.length;
        int[] res = new int[length];
        Integer[] index = new Integer[length];
        //注意对index数组进行填充初始化
        for (int i = 0; i < length; i++) index[i] = i;
        //通过对nums2的排序来对index进行排序，进而保存下num2的顺序
        Arrays.sort(index, Comparator.comparingInt(o -> nums2[o]));
        //被抛弃元素应该放到的位置
        int count = length - 1;
        for (int indexB = 0; indexB < length&&indexA < length; ) {
            if (nums1[indexA] > nums2[index[indexB]]) {
                res[index[indexB]] = nums1[indexA];
                indexB++;
            } else {
                //如果当前元素被废弃
                res[index[count--]] = nums1[indexA];
            }
            indexA++;
        }
        //注意这里没有保留被抛弃掉的num1中的元素，需要进行保留，实际上由于indexA不断在进行抛弃，所以只要将被抛弃的元素放到res的尾部即可
        return res;
    }
}
