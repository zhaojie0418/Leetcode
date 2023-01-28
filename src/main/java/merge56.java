import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class merge56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        //首先对原数组左下标进行排序
        //注意使用自定义比较规则的方式
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        //由于数组形式不便于进行动态的增删，所以这里使用list
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; ++i) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (i == 0|| merged.get(merged.size() - 1)[1] < left) {
                merged.add(new int[]{left,right});
            }else{
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], right);
            }
        }
        //注意其将list形式转换为数组形式的方式
        return merged.toArray(new int[merged.size()][]);
    }
}
