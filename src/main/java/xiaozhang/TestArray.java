package xiaozhang;

import java.util.Arrays;

public class TestArray {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5};
        System.out.println("原始数组为 \n" + Arrays.toString(arr));
        setArray(arr);
        System.out.println("调用方法后的数组为 \n" + Arrays.toString(arr));
    }
    public static void setArray(int[] array) {
        if (array.length > 0) {
            //当传递的参数是数组类型时，由于传递的是引用，所以对数组的修改会影响原数组
            array[0] = 520;
        }
    }
}
