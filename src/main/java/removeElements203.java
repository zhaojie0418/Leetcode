import tools.ListNode;

public class removeElements203 {
    //官方题解（自己写出来了，只是命名不同）
    public ListNode removeElements(ListNode head, int val) {
        //注意这里确实需要使用两个ListNode标注位置
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        //注意这里返回的不是head而是dummyHead.next，否则当head对应的链表值和val全部相同时会报错
        return dummyHead.next;
    }
}
