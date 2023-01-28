import tools.ListNode;

public class removeNthFromEnd19 {
    //倒数n个数考虑使用栈的特性或者使用双指针
    //双指针不止快慢指针，也可以两个指针之间相差特定数量
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
