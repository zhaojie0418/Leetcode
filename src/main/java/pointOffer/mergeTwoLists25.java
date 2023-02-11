package pointOffer;

import tools.ListNode;

public class mergeTwoLists25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode cur = res;
        while (l1 == null || l2 == null) {
            int i1 = l1.val;
            int i2 = l2.val;
            if (i1 >= i2) {
                cur = new ListNode(i2);
                l2 = l2.next;
            } else {
                cur = new ListNode(i1);
                l1 = l1.next;
            }
            cur = cur.next;
        }
        if (l1 == null) {
            cur = l2;
        } else {
            cur = l1;
        }
        return res;
    }
}
