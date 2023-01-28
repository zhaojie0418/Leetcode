import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class findCircleNum547 {
    public int findCircleNum(int[][] isConnected) {
        int num = isConnected.length;
        int[] parent = new int[num];
        //初始化对应数组
        for (int i = 0; i < num; i++) {
            parent[i] = i;
        }
        for(int i = 0;i<num-1;i++){
            for(int j = i+1;j<num;j++){
                if(isConnected[i][j] == 1){
                    union(parent, i, j);
                }
            }
        }
        int provinces = 0;
        for (int i = 0; i < num; i++) {
            //如果这个省城对应的下标和生成对应则相等
            if (parent[i] == i) {
                provinces++;
            }
        }
        return provinces;
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

}
