import java.util.Comparator;
import java.util.PriorityQueue;

public class kthSmallest378 {
    public static void main(String[] args) {
        int[][] arr ={{1,3,5},{6,7,12},{11,14,14}};
        System.out.println(new kthSmallest378().kthSmallest(arr,6));
    }
    //由于是行列分别进行排序，所以说整体很难看出有什么排序规律，唯一能确定的是
    //对于任意一个表格矩阵，其最左上角一定是最小值，其右上角一定是最大值（相较于这个表格矩阵）
    public int kthSmallest(int[][] matrix, int k) {
        int length = matrix.length;
        int[][] b_arr = new int[length][length];
        PriorityQueue<Pair> smallHeap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.value-o2.value;
            }
        });
        smallHeap.add(new Pair(matrix[0][0],0,0));
        if(length == 1){
            return matrix[0][0];
        }
        //注意由于在遍历过程中可能存在
        for (int i = 1; i < k; i++) {
            Pair temp = smallHeap.poll();
            if (temp.x + 1 < length && b_arr[temp.y][temp.x + 1] != 1) {
                smallHeap.add(new Pair(matrix[temp.y][temp.x + 1], temp.x + 1, temp.y));
                b_arr[temp.y][temp.x + 1] = 1;
            }
            if (temp.y + 1 < length && b_arr[temp.y + 1][temp.x] != 1) {
                smallHeap.add(new Pair(matrix[temp.y + 1][temp.x], temp.x, temp.y + 1));
                b_arr[temp.y + 1][temp.x] = 1;
            }
        }
        return smallHeap.poll().value;
    }

    class Pair{
        int value;
        int x;
        int y;

        public Pair(int value2, int x2, int y2) {
            value = value2;
            x = x2;
            y = y2;
        }
    }

    //官方解法：使用归并排序的思想
    //相当于每一行看成是一个有序数组，然后并驾齐驱进行排序
    public int kthSmallest2(int[][] matrix, int k) {
        //其实没必要专门写个Pair类，直接使用int数组即可，注意使用int数组充当元素的写法
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != n - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];
    }

    //官方题解三： 利用划线规律使用二分查找得到
    public int kthSmallest3(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

}
