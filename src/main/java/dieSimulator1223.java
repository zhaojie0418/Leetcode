import java.util.Arrays;

public class dieSimulator1223 {
    //递归和记忆化搜索
    private static final long MOD = (long) 1e9 + 7;
    //为了保证每次递归过程中使用的都是同一个数组，需要定义在类变量中
    private int[] rollMax;
    private int[][][] cache;
    public int dieSimulator(int n, int[] rollMax) {
        //初始化
        this.rollMax = rollMax;
        //因为题目规定骰子有六个面，并且最多只能投掷15次
        this.cache = new int[n][6][15];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 6; ++j)
                //这里的cache[i][j]是一个数组，这里使用Arrays.fill填充
                Arrays.fill(cache[i][j], -1); // -1 表示没有访问过
        //DFS开始(六个都需要遍历)
        long res = 0;
        //由于这里计算的是种类而不是数字，所以使用 0到5 和使用 1到6 效果一样
        for (int i = 0; i < 6; i++) {
            res += dfs(n - 1, i, rollMax[i] - 1);
        }
        //返回结果
        return (int) (res % MOD);
    }

    //i:剩余能够投掷的次数
    //last：上一个投掷的数字
    //left：上一个数字还能投掷的次数
    private int dfs(int i, int last, int left) {
        //应该跳出的情况
        if (i == 0) {
            //这里的0 实际表示的是最后一次投掷
            //自然是最后一种
            return 1;
        }
        if (cache[i][last][left] >= 0) {
            return cache[i][last][left];
        }
        //继续递归的情况
        long res = 0;
        for (int j = 0; j < rollMax.length; ++j)
            if (j != last)
                res += dfs(i - 1, j, rollMax[j] - 1);
            else if (left > 0)
                res += dfs(i - 1, j, left - 1);
        //返回之前注意先存一下
        cache[i][last][left] = (int) (res % MOD);
        return cache[i][last][left];
    }
}
