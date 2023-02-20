package pointOffer;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>(null);
        Queue<TreeNode> queue = new LinkedList<>(){{ add(root); }};
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode tempNode = queue.poll();
                temp.add(tempNode.val);
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
