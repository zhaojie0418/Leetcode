import tools.ListNode;

public class middleNode876 {
    public static void main(String[] args) {

    }
    public static ListNode middleNode(ListNode head) {
        ListNode QuickPointer = head;
        ListNode SlowPointer = head;
        while(true){
            if(QuickPointer.next == null){
                return SlowPointer;
            }else if(QuickPointer.next.next == null){
                return SlowPointer.next;
            }
            QuickPointer = QuickPointer.next.next;
            SlowPointer  = SlowPointer.next;

        }
    }
}
