package interesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class averageFilter {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 1, 4, 3}, {1, 2, 2, 3, 4}, {5, 7, 6, 8, 9}, {5, 7, 6, 8, 8}, {5, 6, 7, 8, 9}};
        int[][] b = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int[][] c = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        int[][] d = {{1,4,3,6,3}, {2,3,5,0,4}, {6,6,7,1,2}, {6,6,7,6,3}};
        System.out.println(new averageFilter().getAverage(d,c));
        System.out.println(new averageFilter().getMid(d));
    }
    public String getAverage(int[][] a, int[][] b){
        int[] x = {0,-1,-1,-1,0,1,1,1};
        int[] y = {-1,-1,0,1,1,1,0,-1};
        int length = a[0].length;
        int height = a.length;
        float[][] res = new float[height][length];
        for (int i = 1; i < length - 1; i++) {
            for (int j = 1; j < height - 1; j++) {
                int sum = a[j][i] * b[1][1];
                int countSum = b[1][1];
                for (int temp = 0; temp < 8; temp++) {
                    int w = b[1 + y[temp]][1 + x[temp]];
                    sum = sum + a[j + y[temp]][i + x[temp]] * w;
                    countSum = countSum + w;
                }
                res[j][i] = (float) sum / countSum;
            }
        }
        return Arrays.deepToString(res);
    }

    public String getMid(int[][] a){
        int[] x = {0,-1,-1,-1,0,1,1,1};
        int[] y = {-1,-1,0,1,1,1,0,-1};
        int length = a[0].length;
        int height = a.length;
        float[][] res = new float[height][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(a[j][i]);
                for (int temp = 0; temp < 8; temp++) {
                    if (!(i + x[temp] >= length || j + y[temp] >= height || i + x[temp] < 0 || j + y[temp] < 0)) {
                        arrayList.add(a[j + y[temp]][i + x[temp]]);
                    }
                }
                arrayList.sort(Comparator.comparingInt(o -> o));
                if (arrayList.size() == 9) {
                    res[j][i] = arrayList.get(4);
                } else {
                    res[j][i] = (float) ((arrayList.get(arrayList.size() / 2 - 1) + arrayList.get(arrayList.size() / 2)) / 2.0);
                }

            }
        }
        return Arrays.deepToString(res);
    }
}
