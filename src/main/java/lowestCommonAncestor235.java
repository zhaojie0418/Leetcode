import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class lowestCommonAncestor235 {

//    设某个节点索引值为index
//    左子节点索引为:2*index+1
//    右子节点索引为:2*index+2
//    父节点索引为:(index-1)/2
    //利用两次遍历的方式分别对两个结点利用二叉树的性质进行查找，并记录两者的查找路径即祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    List<TreeNode> path_p = getPath(root, p);
    List<TreeNode> path_q = getPath(root, q);
    TreeNode ancestor = null;
    //路径中重合的部分即祖先，重合的结点的下标最大值即最近公共祖先
    for (int i = 0; i < path_p.size() && i < path_q.size(); ++i) {
        if (path_p.get(i) == path_q.get(i)) {
            ancestor = path_p.get(i);
        } else {
            break;
        }
    }
    return ancestor;
}
    //使用二叉树性质查询结点值对应的下标
    public List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<TreeNode>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (target.val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        path.add(node);
        return path;
    }

    //实际上可以记录路径在一趟遍历中完成，只要结点在分叉点的方向相同就说明这个节点仍然是祖先
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                //一旦两个结点的分叉方向不同则说明此是便是最晚祖先
                break;
            }
        }
        return ancestor;
    }
}
