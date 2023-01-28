package Tree;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binaryTreePaths257 {
    public List<String> binaryTreePaths_DFS(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPaths(root, "", paths);
        return paths;
    }
    public void constructPaths(TreeNode root, String path, List<String> paths) {
        StringBuilder pathSB = new StringBuilder(path);
        if (root != null) {
            if (root.left == null && root.right == null) {
                pathSB.append(root.val);
                paths.add(pathSB.toString());
            } else {
                pathSB.append(root.val).append("->");
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
        }
    }

    public List<String> binaryTreePaths_BFS(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        nodeQueue.add(root);
        pathQueue.add(String.valueOf(root.val));
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            //这里将path进行了暂存，并且这个path已经从pathQueue中取出，需要使用的时候只需要使用path即可
            String path = pathQueue.poll();
            if (node.left == null && node.right == null) {
                paths.add(path);
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    assert path != null;
                    pathQueue.add(path + "->" + node.left.val);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    pathQueue.add(path + "->" + node.right.val);
                }
            }
        }
        return paths;
    }
}
