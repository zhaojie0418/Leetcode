import tools.ListNode;

public class hasCycle141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        //注意快慢指针的位置
        ListNode slow = head;
        ListNode fast = head.next;
        //TODO 一定会相遇的推导过程
        //如果有环，那么终究会相遇
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
