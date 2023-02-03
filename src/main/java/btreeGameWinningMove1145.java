import tools.TreeNode;

public class btreeGameWinningMove1145 {
    private int x, lsz, rsz;

    //这里实际上一共就三种情况，先手结点的
    //左子树
    //右子树
    //父节点子树
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        this.x = x;
        dfs(root);
        return Math.max(Math.max(lsz, rsz), n - 1 - lsz - rsz) * 2 > n;
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int ls = dfs(node.left);
        int rs = dfs(node.right);
        //如果node.val == x，则说明完全递归完成
        if (node.val == x) {
            lsz = ls;
            rsz = rs;
        }
        //父节点实际上就是两者+1
        return ls + rs + 1;
    }

}
