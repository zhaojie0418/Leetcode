import tools.ListNode;

public class detectCycle142 {

//    从相遇点到入环点的距离加上 n-1 圈的环长，恰好等于从链表头部到入环点的距离因此，当发现 slow 与 fast 相遇时，我们再额外使用一个指针ptr
//    起始，它指向链表头部；随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;

    }
}
