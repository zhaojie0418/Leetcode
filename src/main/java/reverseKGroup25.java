import tools.ListNode;

import java.util.ArrayList;
import java.util.List;

public class reverseKGroup25 {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode temp = head;
        for(int i = 1;i<=2;i++){
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        head = new reverseKGroup25().reverseKGroup(head.next,2);
        while(head!=null){
            System.out.print(head.val+"  ");
            head = head.next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1){
            return head;
        }
        int count = 0;
        boolean if_first = true;
        ListNode cur = head;
        //每次确保res反转好的链表的最后一个
        ListNode res = new ListNode();
        ListNode resHead = new ListNode();
        ListNode temp = new ListNode();
        while(true){
            ListNode tempHead = cur;
            //计数 k-1 个(因为要对最后一个结点进行特殊处理所以到k-1个)
            while(count != k-1){
                if(cur==null||cur.next==null){
                    //将剩余部分拼接到对应的res上
                    res.next = tempHead;
                    return resHead;
                }else {
                    cur = cur.next;
                    count++;
                }
            }
            //对计数器count清空
            count = 0;

            //将最后一个结点的next置空
            temp = cur.next;
            cur.next = null;
            cur = temp;

            //将反转好的链表挂载到res上，并将res指向挂载好的链表末尾结点
            if(if_first){
                resHead = reverseList(tempHead);
                res.next = resHead;
                if_first = false;
            }else{
                res.next = reverseList(tempHead);
            }
            res = tempHead;  //tempHead一直指向曾经的头，也就是现在的尾节点

        }
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
