public class kthFactor1492 {
    public int kthFactor(int n, int k) {
        //实际还是从1开始递增判断是否为因子，唯一优化是在于平方处即可停止递归
        // from start to sqrt(n)
        int i = 1;
        for(; i*i < n; i ++) {
            if((n%i == 0) && (--k == 0)) {
                return i;
            }
        }

        if(i * i != n) {
            i --;
        }
        // from sqrt(n) again
        for(; i >= 1; i --) {
            if((n%i == 0) && (--k==0)) {
                return n/i;
            }
        }
        return -1;
    }
}
