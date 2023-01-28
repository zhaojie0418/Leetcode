public class climbStairs70 {
    public static void main(String[] args) {
        System.out.println(new climbStairs70().climbStairs(4));
    }
    //实际上简单递归都能使用迭代实现，并且运行效率会快很多
    public int climbStairs(int n) {
        if(n==1||n==2||n==3)
            return n;
        else
            return climbStairs(n-1)+climbStairs(n-2);
    }
    //使用迭代方法来求解
    public int climpStair_2(int n){
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
    //使用斐波那契数列的通项公式求解
    public int climbStairs_3(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) Math.round(fibn / sqrt5);
    }

}
