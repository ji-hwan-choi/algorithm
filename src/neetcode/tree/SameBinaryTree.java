package neetcode.tree;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class SameBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));

//        TreeNode p = new TreeNode(4, new TreeNode(7), null);
//        TreeNode q = new TreeNode(4, null, new TreeNode(7));

        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null || p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static boolean isSameTreeBFS(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            TreeNode nodeP = queue.poll();
            TreeNode nodeQ = queue.poll();

            if (nodeP == null && nodeQ == null) {
                continue;
            }
            else if (nodeP == null || nodeQ == null || nodeP.val != nodeQ.val) {
                return false;
            }

            queue.offer(nodeP.left);
            queue.offer(nodeQ.left);

            queue.offer(nodeP.right);
            queue.offer(nodeQ.right);
        }

        return true;
    }
}
