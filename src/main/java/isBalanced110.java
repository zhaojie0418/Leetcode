public class isBalanced110 {
    public boolean isBalanced(TreeNode root) {
        //自底向上查找，一旦查找到不平衡的树就立马返回
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        //唯一真正对其赋值为-1 的地方
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

}
