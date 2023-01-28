import java.util.Deque;
import java.util.LinkedList;

public class longestValidParentheses32 {
    public int longestValidParentheses(String s) {
        Deque<Character> stack = new LinkedList<>();
        int leftCount = 0;
        int maxLength = 0;
        int tempLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
                leftCount++;
            } else {
                if (leftCount == 0) {
                    break;
                } else {
                    if (stack.peek() == '(') {
                        stack.pop();
                        tempLength += 2;
                        leftCount--;
                    } else {
                        stack.push(c);
                    }
                }
            }
        }

        return 0;
    }
    //官方解法2：使用栈的特性
    public int longestValidParentheses2(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

}
