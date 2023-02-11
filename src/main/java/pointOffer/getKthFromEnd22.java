package pointOffer;

import tools.ListNode;

public class getKthFromEnd22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode faster = head;
        ListNode slower = head;
        for (int i = 0; i < k; i++) {
            faster = faster.next;
        }
        while (faster != null) {
            faster = faster.next;
            slower = slower.next;
        }
        return slower;
    }
}
