package pointOffer;

import tools.ListNode;

public class getIntersectionNode52 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA.next == null || headB.next == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
