package my_Algorithm.my_listnode;

public class MyTest {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode p = head;
        while(p!=null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        ListNode node = reverseList(head);
        p = node;
        System.out.println();
        while(p!=null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp;
        while(cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
