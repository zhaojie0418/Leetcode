import tools.ListNode;

public class deleteDuplicates83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next.next != null) {
            if (temp.next.val == temp.next.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }
}
