import tools.ListNode;

public class reverseList206 {
    public static void main(String[] args) {

    }
    //反转链表
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
    //递归算法
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //注意递归过程中，直到递归到最后一个结点实际上才开始运行
        //并且每一层递归中的head一定是newHead的前一个结点
        ListNode newHead = reverseList2(head.next);
        //创建反向链表的连接
        head.next.next = head;
        //删除原来正向链表的连接
        head.next = null;
        return newHead;
    }

}
