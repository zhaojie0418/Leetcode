import java.util.List;

public class minimumTotal120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        //row是行数  min是记录下来的最小值
        //感觉还是要对三角形进行遍历，并且动态规划的实质并不是减少遍历，而是保留之前遍历过的数据来规避重复遍历
        int row = triangle.size();
        int[][] dp = new int[row][row];
        //对初始值进行赋值
        //可以使用一维数组来代替dp数组，很好想只是懒得写
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1;i<row;i++){
            for(int j = 0;j<i+1;j++){
               if(j==0){
                   dp[i][j] = dp[i-1][j]+triangle.get(i).get(j);
                   continue;
               }
               if(j==i){
                   dp[i][j] = dp[i-1][j-1]+triangle.get(i).get(j);
                   continue;
               }
               dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1])+triangle.get(i).get(j);
            }
        }
        int min = dp[row-1][0];
        for(int i = 1;i<row;i++){
            min = Math.min(dp[row - 1][i], min);
        }
        return min;
    }
}
