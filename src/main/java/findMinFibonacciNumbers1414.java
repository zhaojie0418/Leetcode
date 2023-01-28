import java.util.ArrayList;
import java.util.List;

public class findMinFibonacciNumbers1414 {
    //由于斐波那契数的特性，保证了后一个数一定是前两个数之和，所以如果能用前面两个数表示那么一定能用后面两个数表示
    public int findMinFibonacciNumbers(int k) {
        List<Integer> f = new ArrayList<Integer>();
        f.add(1);
        int a = 1, b = 1;
        //产生斐波那契数列的计算方法
        //当退出循环时一定保证了当前数列中的最大值是小于k的
        while (a + b <= k) {
            int c = a + b;
            f.add(c);
            a = b;
            b = c;
        }
        int res = 0;
        for (int i = f.size() - 1; i >= 0 && k > 0; i--) {
            int num = f.get(i);
            if (k >= num) {
                k -= num;
                res++;
            }
        }
        return k;
    }
}
