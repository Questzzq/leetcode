package my_linkNode;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode result = swapPairs(head);
        ListNode point = result;
        while (point != null) {
            System.out.print(point.val + "  ");
            point = point.next;
        }
        System.out.println();
        long a = 3L;
        float b = a;
        System.out.println(b);
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode point = head;
        while(first != null && second != null) {
            point = second.next;
            second.next = first;
            first.next = point;
            if(point != null && point.next != null) {
                first = point;
                second = point.next;
            } else {
                break;
            }
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

