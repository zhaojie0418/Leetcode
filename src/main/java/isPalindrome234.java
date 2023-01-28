import tools.ListNode;

import java.util.Stack;

public class isPalindrome234 {
    //TODO 评论区的哈希法学习？？
    public boolean isPalindrome(ListNode head) {
        //使用快慢指针，快指针达到末尾的时候，慢指针正好在中间
        ListNode fast = head.next;
        ListNode slow = head;
        //只有一个元素当然是回文链表
        if(fast == null)
            return true;
        //注意并列条件需要注意顺序，如果前一个条件已经发生了冲突就不会检测第二个条件
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //指向下一个，下一个才是真正要遍历的结点
        slow = slow.next;
        //将右侧的链表进行翻转，相当于在右边拆下来一个就安到左边的新链表上
        //  prev是记录先前的结点（最后就自然成为最右边的结点，也就是头结点）
        //  curr是待拆下来放左边的结点
        //  next是暂存下一个节点的变量
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        while(prev!=null){
            if(head.val != prev.val){
                return false;
            }
            head = head.next;
            prev = prev.next;
        }
        return true;
    }
}
