import java.util.ArrayList;
import java.util.List;

public class spiralOrder54 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new spiralOrder54().spiralOrder(arr));
    }
    //对矩阵进行旋转输出
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> integerList = new ArrayList<>();
        //初始值的起点
        int x = 0;
        int y = 0;
        //定义二维数组的行列值
        int m = matrix.length;
        int n = matrix[0].length;
        //分别是向右，向下，向左，向上
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        //设置count来记录对应的方向
        int count = 0;
        int nums = 0;
        //遍历完二维数组中的每一个元素
        while(true){
            int tx = x + dx[count%4];
            int ty = y + dy[count%4];
            if(tx<n&&ty<m&&tx>=0&&ty>=0&&matrix[ty][tx]!=250){
                integerList.add(matrix[y][x]);
                //使用250来标记已经遍历过的元素
                matrix[y][x] = 250;
                count = count%4;
                x = tx;
                y = ty;
            }else{
                //因为只会在上面进入if后才会对count的值进行模除，所以只要连续加四次count值就一定会大于四
                if(count>4) {
                    integerList.add(matrix[y][x]);
                    break;
                }
                count++;
            }
        }
        return integerList;
    }
}
