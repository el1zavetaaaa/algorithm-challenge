package algorithm.challenge.seasonfirst2026buildhabit;

/**
 * @author yelyzavetalubenets
 **/
public class CountCompleteTreeNodes222 {

    public static void main(String[] args) {
        final TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        System.out.println(countNodes(root));
    }

    public static int countNodes(TreeNode root) {
        TreeNode firstRoot = root;
        int countLeft = 0;

        while (root!= null){
            countLeft++;
            root = root.left;
        }

        root = firstRoot;
        int countRight = 0;

        while (root!= null){
            countRight++;
            root = root.right;
        }

        if(countLeft == countRight){
            return (int) Math.pow(2, countLeft) - 1;
        }
        else {
            root = firstRoot;
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
