import tools.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class isValidBST98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    //递归版本判断二叉排序树
    public boolean isValidBST(TreeNode node, long lower, long upper) {
        //表示递归到了子节点
        if (node == null) {
            return true;
        }
        //表示该节点不满足大小关系
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        //对子节点进行递归操作
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    //根据二叉排序树的性质，只要是二叉排序树，则进行中序遍历得到的结果一定是升序的
    //中序遍历即中根遍历，即根结点是在中间输出的
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        //这里本来使用空值进行赋值，这里为了保证不会小于限定值，故使用标量，实际上最后使用的是每次迭代的值
        double inorder = -Double.MAX_VALUE;

        //TODO 记忆经典中序遍历
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }


}
