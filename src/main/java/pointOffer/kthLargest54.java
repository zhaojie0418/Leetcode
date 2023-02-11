package pointOffer;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class kthLargest54 {
    private static List<Integer> arr=new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        //中序遍历是递增序列
        inOrder(root);
        //寻找第k大的数，输出
        return arr.get(arr.size()-k);
    }
    //中序遍历
    private static void inOrder(TreeNode root){
        if(root==null)
            return;
        inOrder(root.left);
        arr.add(root.val);
        inOrder(root.right);

    }
}
