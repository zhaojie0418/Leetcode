import tools.ListNode;

public class mergeInBetween1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int count = 0;
        ListNode head1 = list1;
        while (count < a - 1) {
            head1 = head1.next;
            count++;
        }
        ListNode temp = head1;
        while (count <= b) {
            temp = temp.next;
            count++;
        }
        head1.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = temp;
        return list1;
    }
}
