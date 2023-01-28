import tools.ListNode;

public class reorderList143 {
    public void reorderList(ListNode head) {
        //和官方题解使用的内存相同
        //使用快慢指针得到中间结点
        ListNode fast = head.next;
        ListNode slow = head;

        //只有一个结点则可以直接返回
        if(fast == null)  return ;

        //注意并列条件需要注意顺序，如果前一个条件已经发生了冲突就不会检测第二个条件
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //对两个链表进行操作
        ListNode tail = reverseList(slow.next);
        ListNode tempHead;
        ListNode tempTail;
        while(tail!=null&&head!=null){
            tempHead = head.next;
            tempTail = tail.next;
            head.next = tail;
            tail.next = tempHead;
            head = tempHead;
            tail = tempTail;
        }
        head.next = null;

    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
