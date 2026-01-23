package algorithm.challenge.seasonfirst2026buildhabit;

import java.util.*;

/**
 * @author yelyzavetalubenets
 **/
public class NaryTreePostorderTraversal590 {
    public static void main(String[] args) {
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        Node node3 = new Node(3, Arrays.asList(node5, node6));

        Node node2 = new Node(2);
        Node node4 = new Node(4);

        Node root = new Node(1, Arrays.asList(node3, node2, node4));

        final List<Integer> res = postorder(root);
        final List<Integer> res2 = postorder2(root);

        for (Integer result : res) {
            System.out.println(result);
        }

        System.out.println("--------2nd solution--------");

        for (Integer result2 : res2) {
            System.out.println(result2);
        }
    }

    public static List<Integer> postorder2(Node root) {
        final List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        final Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            res.add(current.val);

            if (current.children != null) {
                for (Node child : current.children) {
                    stack.push(child);
                }
            }
        }

        Collections.reverse(res);
        return res;
    }

    public static List<Integer> postorder(Node root) {
        final List<Integer> res = new ArrayList<>();
        return postOrderTraversal(root, res);
    }

    private static List<Integer> postOrderTraversal(Node root, List<Integer> res) {
        if (root == null)
            return res;

        if (root.children != null) {
            for (Node node : root.children) {
                postOrderTraversal(node, res);
            }
        }
        res.add(root.val);
        return res;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
