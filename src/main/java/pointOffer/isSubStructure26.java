package pointOffer;

import tools.TreeNode;

public class isSubStructure26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        //B是A的子结构的前提：B为空或者当前节点对应的结点至少要相同
        if(B == null) return true;                     //空一定是树的子结构
        if(A == null || A.val != B.val) return false;  //空一定无法成为别人的父结构
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
