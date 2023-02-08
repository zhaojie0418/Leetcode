package pointOffer;

import tools.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class buildTree072 {
    //为了快速获取到根结点对应的值
    private Map<Integer, Integer> indexMap;
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        int inorder_root = indexMap.get(preorder[preorder_left]);
        TreeNode root = new TreeNode(preorder[preorder_left]);
        int sub = inorder_root - inorder_left;
        root.left = myBuildTree(preorder, inorder,preorder_left+1,preorder_left+sub,inorder_left,inorder_root-1 );
        root.right = myBuildTree(preorder, inorder, preorder_left + sub + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i); //快速求得对应结点的下标
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}
