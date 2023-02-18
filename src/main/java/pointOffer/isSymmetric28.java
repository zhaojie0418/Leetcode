package pointOffer;

import tools.TreeNode;

public class isSymmetric28 {
    public boolean isSymmetric(TreeNode root) {
        //需要两个参数所以需要重新写一个新的函数
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        //只要有一个为null就说明不对称
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
