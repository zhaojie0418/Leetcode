import tools.ListNode;

public class mergeTwoLists21 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode();

    }
    //合并两个有序链表
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode begin = new ListNode();
        ListNode head  = begin;
        for(int i =0;list1!=null&&list2!=null;i++){
            if(list1.val > list2.val){
                begin.next = new ListNode(list2.val);
                begin = begin.next;
                list2 = list2.next;
            }else if (list1.val < list2.val){
                begin.next = new ListNode(list1.val);
                begin = begin.next;
                list1 = list1.next;
            }else {
                begin.next = new ListNode(list1.val);
                begin = begin.next;
                begin.next = new ListNode(list1.val);
                begin = begin.next;
                list1 = list1.next;
                list2 = list2.next;
            }
        }
        begin.next = list1 == null ? list2 : list1;
        return head.next;
    }
    //官方解法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
    //递归解法（好奇妙啊）
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}


