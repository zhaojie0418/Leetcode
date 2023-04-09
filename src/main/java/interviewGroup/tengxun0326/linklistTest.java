package interviewGroup.tengxun0326;


import tools.ListNode;

public class linklistTest {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
    }
    public ListNode reorderList (ListNode head) {
        // write code here
        ListNode[] indexArr = new ListNode[4];
        ListNode temp = head;
        boolean if_end = false;
        boolean if_first = true;
        ListNode pre = head;
        ListNode res = head;
        while (temp != null) {
            int i;
            for ( i = 0; i < 4; i++) {
                if (temp != null) {
                    indexArr[i] = temp;
                    temp = temp.next;
                } else {
                    if_end = true;
                    break;
                }
            }
            if (!if_end) {
                ListNode tempNext = indexArr[3].next;
                indexArr[1].next = tempNext;
                indexArr[3].next = indexArr[0];
                pre.next = indexArr[3].next;
                pre = indexArr[1];
                temp = tempNext;
                if (if_first) {
                    res = indexArr[2];
                    if_first = false;
                }
            } else { //说明现在不满4个
                if (i == 3) {
                    indexArr[2].next = indexArr[0];
                    pre.next = indexArr[2];
                }
                if (if_first) {
                    res = indexArr[2];
                    if_first = false;
                }
            }
        }

        return res;
    }
}
