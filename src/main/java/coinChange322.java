import java.util.Arrays;

public class coinChange322 {
    public static void main(String[] args) {
        int[] arr = {1,2,5};
        System.out.println(new coinChange322().coinChange(arr,11));
    }
    //自己的解法，有些错误需要修改
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int length = coins.length;
        int count  = 0;
        //这里为了避免有可能使用面值较小的零钱能够分开，而使用面值较大的不能分开的情况出现，每次遍历过一次就将length减一
        //这里是个人的思路，但是实际上并不能使用贪心算法，暴力解法应该枚举所有零钱组合进行遍历
        while(length!=0){
            for(int i = length-1;i>=0;i--){
                //优先使用面值较大的零钱进行兑换
                if(amount>=coins[i]){
                    count = count + amount/coins[i];
                    amount = amount%coins[i];
                }
                if(amount == 0){
                    return count;
                }
            }
            count = 0;
            length--;
        }

        return -1;
    }

    //官方解法1：使用记忆化搜索思想（当需要计算某个值时，先检查是否存储了这个值，如果存储了这个值就不用重复计算）  F(S)=F(S−C)+1  （其中S是金额，C是某一特定零钱的面额）
    //更多的使用了自顶向下的思想
    public int coinChange2(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    //coins是给定的硬币的种类，rem是剩余的余额，count是用于记忆化搜索所剩下的硬币数量
    private int coinChange(int[] coins, int rem, int[] count) {
        //因为使用给定的硬币进行兑换应当不会出现兑换硬币后产生负数的情况
        if (rem < 0) {
            return -1;
        }
        //兑换完后正好兑换完毕，自然不需要进行对硬币数量的添加
        if (rem == 0) {
            return 0;
        }
        //这里的rem - 1 只是因为使用了数字下标为n-1的元素来表示金额为n的所需硬币数量
        //如果已经知道了金额为n的所需硬币数量就无需重复计算，根据记忆化搜索查询即可
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        //注意对寻找最小值的初始化操作
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            //遍历所有给定硬币所能够兑换的可能性
            int res = coinChange(coins, rem - coin, count);
            //如果能换并且比当前记录的min数更小，说明当前情况下即为能够兑换的硬币数量最少，迭代min的值
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        //避免出现不能兑换的情况
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

    //官方题解2，使用动态规划的算法  问题的答案是通过子问题的最优解得到的故可以使用动态规划求解
    //更多的使用了自底向上的思想
    public int coinChange3(int[] coins, int amount) {
        //由于是自底向上所以需要设定算法的边界

        int max = amount + 1;
        int[] dp = new int[amount + 1];
        //对dp数组全部填装max值
        //这一目的在于当金额很小时，无法用所给硬币进行兑换时，无需对其对应金额的dp数组操作，在使用min方法的时候就已经过滤过了
        Arrays.fill(dp, max);
        dp[0] = 0;
        //i是对金额的遍历
        for (int i = 1; i <= amount; i++) {
            //j是对硬币种类的遍历
            for (int j = 0; j < coins.length; j++) {
                //只要 coins[j] <= i 面值小就一定能用这个硬币兑换
                if (coins[j] <= i) {
                    //等于dp[i] = dp[i]实际上就是兑换不了的意思
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
