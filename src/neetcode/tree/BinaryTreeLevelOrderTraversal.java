package neetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 문제 : Binary Tree Level Order Traversal
 * https://neetcode.io/problems/level-order-traversal-of-binary-tree?list=neetcode150
 */
public class BinaryTreeLevelOrderTraversal {

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

        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6),
                        new TreeNode(7)));

        List<List<Integer>> result = levelOrder(treeNode);
        System.out.println("result = " + result);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode treeNode = queue.poll();

                if (treeNode != null) {
                    list.add(treeNode.val);
                    if (treeNode.left != null)
                        queue.offer(treeNode.left);
                    if (treeNode.right != null)
                        queue.offer(treeNode.right);
                }
            }
            result.add(list);
        }

        return result;
    }

}

