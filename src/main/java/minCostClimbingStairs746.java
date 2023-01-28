public class minCostClimbingStairs746 {
    public static void main(String[] args) {
        int[] test = new int[]{1,100,1,1,1,100,1,1,100,1};
        System.out.println(new minCostClimbingStairs746().minCostClimbingStairs(test));
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] sum = new int[cost.length];
        sum[0] = cost[0];
        sum[1] = cost[1];
        for(int i =2;i<cost.length;i++){
            sum[i] = Math.min(sum[i-1],sum[i-2])+cost[i];
        }
        return Math.min(sum[cost.length-1],sum[cost.length-2]);
    }
}
