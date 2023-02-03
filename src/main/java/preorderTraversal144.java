import tools.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class preorderTraversal144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root,res);
        return res;
    }
    public void preorder(TreeNode root,List<Integer> res){
        if(root==null) return;
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }

    //迭代方法进行先序遍历
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            //不断的把根结点存到栈中，并且在将根结点存入栈之前对其添加到res中
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            //由于一直向左边操作，所以当返回时一定达到了最左边的结点
            //弹出一个最底层的根结点
            node = stack.pop();

            node = node.right;
        }
        return res;
    }

}
