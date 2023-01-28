package Tree;

import tools.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class kthSmallest230 {
    //注意可以通过分治的思想，统计左右树的结点数来减少计算量
    public int kthSmallest(TreeNode root, int k){
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode x = null, y = null, pred = null;
        int count = 0;
        //常规部分
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //特殊化部分
            root = stack.pop();
            count++;
            if (count == k) {
                return root.val;
            }

            //常规部分
            root = root.right;
        }
        return count;
    }
}
