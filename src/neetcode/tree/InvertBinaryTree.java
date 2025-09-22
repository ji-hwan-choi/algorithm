package neetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 문제 : Invert Binary Tree
 * https://neetcode.io/problems/invert-a-binary-tree?list=neetcode150
 */
public class InvertBinaryTree {

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
        //     1
        //    / \
        //   2   3
        //  / \ / \
        // 4  5 6  7
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        root.left = left;
        root.right = right;

        TreeNode invertedTree = invertTreeBFS(root);
    }

    public static TreeNode invertTree(TreeNode root) {

        if (root == null) return null;

        TreeNode right = root.right;
        TreeNode left = root.left;

        invertTree(right);
        invertTree(left);
        root.left = right;
        root.right = left;

        return root;
    }

    public static TreeNode invertTreeBFS(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();

            TreeNode temp = treeNode.right;
            treeNode.right = treeNode.left;
            treeNode.left = temp;

            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
        }

        return root;
    }
}
