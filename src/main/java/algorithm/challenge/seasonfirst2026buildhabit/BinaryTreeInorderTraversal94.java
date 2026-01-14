package algorithm.challenge.seasonfirst2026buildhabit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yelyzavetalubenets
 **/
public class BinaryTreeInorderTraversal94 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(9);
        final List<Integer> res = inorderTraversal(root);

        for (int result : res) {
            System.out.println(result);
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        final List<Integer> res = new ArrayList<>();

        inorderTraversal(root, res);

        return res;
    }

    private static void inorderTraversal(TreeNode node, List<Integer> res) {
        if (node == null)
            return;
        inorderTraversal(node.left, res);

        res.add(node.val);

        inorderTraversal(node.right, res);
    }

    static class TreeNode {
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
}
