package pointOffer;

import tools.ListNode;

import java.util.Stack;

public class reversePrint06 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        while (head != null) {
            count++;
            stack.push(head.val);
            head = head.next;
        }
        int[] arr = new int[count];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }
}
