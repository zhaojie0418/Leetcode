package pointOffer;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class levelOrder32 {
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        //使用队列进行排序，然后从左到右进行输出
        Queue<TreeNode> queue = new LinkedList<>(){};
        queue.add(root);
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            ans.add(temp.val);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }

}
