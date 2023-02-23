import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class circularPermutation1238 {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> retRight = new LinkedList<>();
        List<Integer> retLeft  = new LinkedList<>();
        int i = 0;
        for (; i < 1 << n; i++) {
            int temp = (i >> 1) ^ i;
            if (temp == start) {
                retLeft.add(temp);
                for (i = i + 1; i < 1 << n; i++) {
                    retLeft.add((i >> 1) ^ i);
                }
                break;
            }
            retRight.add(temp);
        }
        retLeft.addAll(retRight);
        return retLeft;
    }
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < 1 << n; i++) {
            ret.add((i >> 1) ^ i);
        }
        return ret;
    }
}
