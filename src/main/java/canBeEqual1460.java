import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class canBeEqual1460 {
    //所谓的交换只是障眼法，因为对大数组进行交换实际上就是两两不断相互交换得来的
    //所以只需要两个数组中的元素完全相同即可，而不需要考虑对应的数据
    //这里先进行排序然后比较即可
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        //记得使用equals进行判断
        return Arrays.equals(target, arr);
    }


}
