package my_Algorithm.my_listnode;

public class Solution {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        ListNode res = swapPairs(root);
        ListNode p = res;
        while(p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode v = new ListNode();
        v.next = head;
        ListNode p1, p2, p3, p4;
        p2 = v;
        p3 = v;
        while(p2.next != null && p2.next.next != null) {
            p1 = p3.next;
            p4 = p3.next.next;
            p3.next = p4;
            p4 = p3.next.next;
            p3.next.next = p1;
            p1.next = p4;
            p2 = p3.next.next;
            p3 = p2;
        }
        return v.next;
    }
}
