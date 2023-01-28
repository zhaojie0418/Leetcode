import tools.ListNode;

public class oddEvenList328 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for(int i = 2;i<6;i++){
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        ListNode result = new oddEvenList328().oddEvenList(head);
        while(result!=null){
            System.out.print(result.val+"  ");
            result = result.next;
        }

    }
    //官方题解
        public ListNode oddEvenList(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode evenHead = head.next;
            ListNode odd = head, even = evenHead;
            //注意奇数链和偶数链必须同时处理，否则当奇数链处理完了，偶数链已经全都掉下来成孤立的结点了
            //注意while的条件，只需要两个条件即可，并且还要注意先后顺序
            while (even != null && even.next != null) {
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            return head;
        }

}
