import tools.TreeNode;

public class minDepth111 {
    public int minDepth(TreeNode root) {
//        if(root == null) return 0;
//        int m1 = minDepth(root.left);
//        int m2 = minDepth(root.right);
//        //1.如果左孩子和右孩子有为空的情况，直接返回m1+m2+1
//        //2.如果都不为空，返回较小深度+1
//        return root.left == null || root.right == null ? m1 + m2 + 1 : Math.min(m1,m2) + 1;
        return dfs_depth(root);
    }


    //注意这个dfs是用于计算子节点有多少个数的
    public int dfs_count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs_count(node.left);
        int right = dfs_count(node.right);
        return left + right + 1;
    }

    public int dfs_depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs_depth(node.left);
        int right = dfs_depth(node.right);
        //注意对于左右结点为null的情况，如果其中有一个为null，那么其结果就是0，会干扰Math.min()的计算
        return node.left == null || node.right == null ? left + right + 1 : Math.min(left,right) + 1;
    }

}
