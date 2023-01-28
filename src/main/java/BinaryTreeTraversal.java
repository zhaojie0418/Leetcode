import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeTraversal {
    //递归版本的前序遍历（中序和后序省略）
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
    //TODO 理解迭代方法的前中后遍历
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

    //迭代方法进行中序遍历（左  根  右）
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            //不断向左遍历并且存入对应的根结点
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            //不用担心所谓的左节点没有被输出，因为左节点实际上也是根结点，其在跳出循环时就已经被上一层的循环当成根结点输出了
            root = stk.pop();
            //第一次跳出循环后输出的这个节点实际上是根结点，因为第一次循环到达的是最下面的没有左节点的结点
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    //迭代方法进行后序遍历（左  右  根）
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }


}
