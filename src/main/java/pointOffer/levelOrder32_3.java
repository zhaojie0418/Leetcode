package pointOffer;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>(){{ add(root); }};
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        while (!queue.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode tempNode = queue.poll();
                //其实和原本题目只需要改变这一点逻辑，因为只需要在最最后面输出答案的时候倒着放就可以了
                if(count % 2 == 0) temp.addLast(tempNode.val); // 偶数层 -> 队列头部
                else temp.addFirst(tempNode.val); // 奇数层 -> 队列尾部
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            count++;
            res.add(temp);
        }
        return res;
    }
}
