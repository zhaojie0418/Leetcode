package Tree;

import tools.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class isValidBST98 {
    class Solution {
        public boolean isValidBST(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            double inorder = -Double.MAX_VALUE;

            //常规部分
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }

                //特殊化部分
                root = stack.pop();
                // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
                if (root.val <= inorder) {
                    return false;
                }
                inorder = root.val;

                //常规部分
                root = root.right;
            }
            return true;
        }
    }
}
