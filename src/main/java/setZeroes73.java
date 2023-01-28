import java.util.*;

public class setZeroes73 {
    public static void main(String[] args) {
        int[][] arr = {{1,1,1},{1,0,1},{1,1,1}};
        new setZeroes73().setZeroes(arr);
        //使用deepToString遍历
        System.out.println(Arrays.deepToString(arr));
    }
    public void setZeroes(int[][] matrix) {
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> deque = new LinkedList<>();
        for(int i = 0;i<m;i++){
            for (int j = 0;j<n;j++){
                if(matrix[i][j]==0)
                    deque.add(new int[]{i,j});
            }
        }
        while(!deque.isEmpty()){
            int[] arr = deque.poll();
            putZero(arr[0],arr[1],matrix,deque);
        }
    }

    public void putZero(int i ,int j,int[][] matrix,Queue<int[]> deque){
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        int m = matrix.length;
        int n = matrix[0].length;
        for(int count =0;count<4;count++){
            int mx = i + dx[count], my = j + dy[count];
            if (mx >= 0 && mx < n && my >= 0 && my < m ) {
                if(matrix[mx][my]==0){
                    deque.add(new int[]{mx,my});
                }
                matrix[mx][my] = 0;
            }
        }
    }
}
