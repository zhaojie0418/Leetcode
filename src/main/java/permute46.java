import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class permute46 {
    public List<List<Integer>> permute(int[] nums) {
        //这里考虑树形结构的遍历方式，使用深度优先算法进行回溯的思想进行解题
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        //将题目中给定的数组转化为list类型
        //注意output本身就已经和给定数字数量相同，其本身就已经是承载数字的载体
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    //具体的回溯算法
    //n 是数组中数字的数量，是固定值，first是开始进行选择的起始值
    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了，即数组的长度正好跟给定的数字数量一致
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        //first之前的已经被遍历过了，所以必须要在first之后进行遍历
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}
