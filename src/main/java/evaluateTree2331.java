import tools.TreeNode;

public class evaluateTree2331 {
    public boolean evaluateTree(TreeNode root) {
        //因为项目本身限定了二叉树只能有0个或者2个子节点
        if (root.left == null) {
            return root.val == 1;//巧妙转换
        }
        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }
}
