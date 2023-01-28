import tools.Node;

import java.util.ArrayList;
import java.util.List;

//N 叉树的前序遍历
public class preorder589 {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    public void helper(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node ch : root.children) {
            //在Node的定义中，使用对应的List存放一个结点的所有子节点
            helper(ch, res);
        }
    }

    //TODO 递归版本的前序遍历

}
