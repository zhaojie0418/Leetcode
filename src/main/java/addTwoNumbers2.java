import tools.ListNode;

public class addTwoNumbers2 {
    public static void main(String[] args) {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode result = head;
        int sum;
        int carry = 0;
        while(l1!=null||l2!=null){
            if(l1==null){
                sum = l2.val+carry;
                carry = sum>=10?1:0;
                sum = sum%10;
                head.next = new ListNode(sum);
                head = head.next;
                l2   = l2.next;
                continue;
            }else if(l2==null){
                sum = l1.val+carry;
                carry = sum>=10?1:0;
                sum = sum%10;
                head.next = new ListNode(sum);
                head = head.next;
                l1   = l1.next;
                continue;
            }else{
                sum=l1.val+l2.val+carry;
            }
            carry = sum>=10?1:0;
            sum = sum%10;
            head.next = new ListNode(sum);
            head = head.next;
            l1   = l1.next;
            l2   = l2.next;
        }
        //注意最后一个进位不要忘了
        if(carry==1){
            head.next = new ListNode(1);
        }
        return result.next;
    }
}
