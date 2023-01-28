package Tree;

import tools.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class recoverTree99 {
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode x = null, y = null, pred = null;

        //常规部分
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            //特殊化部分
            //如果该节点是有问题的部分
            if (pred != null && root.val < pred.val) {
                y = root;
                //说明这是第一次到有问题的结点
                if (x == null) {
                    x = pred;
                } else {
                    break;
                }
            }
            //如果该节点不是有问题的部分
            pred = root;

            //常规部分
            root = root.right;
        }

        swap(x, y);
    }

    public void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}
