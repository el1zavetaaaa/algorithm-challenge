package algorithm.challenge.seasonfirst2026buildhabit;

/**
 * @author yelyzavetalubenets
 **/
public class LinkedListCycle114 {
    public static void main(String[] args) {
        final ListNode root = new ListNode(1);
        final ListNode cycle = new ListNode(2);
        root.next = cycle;
        root.next.next = new ListNode(0);
        root.next.next.next = new ListNode(-4);
        root.next.next.next.next = cycle;
        System.out.println(hasCycle(root));

        final ListNode root2 = new ListNode(1);
        System.out.println(hasCycle(root2));

        final ListNode root3 = new ListNode(1);
        root3.next = new ListNode(2);
        root3.next.next = root3;
        System.out.println(hasCycle(root3));
    }

    public static boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }

        ListNode slowPointer = head.next;
        ListNode fastPointer = head.next != null ? head.next.next : null;

        while (fastPointer != null){
            if(fastPointer== slowPointer){
                return true;
            }

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next != null ? fastPointer.next.next : null;
        }

        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
