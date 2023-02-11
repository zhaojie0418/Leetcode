package pointOffer;

import tools.ListNode;

public class deleteNode18 {
    public ListNode deleteNode(ListNode head, int val) {
        //先处理链表头的情况
        if (head.val == val) {
            head = head.next;
            return head;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }
}
