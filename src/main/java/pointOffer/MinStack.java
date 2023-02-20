package pointOffer;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;//维护的是当前栈中的最小值

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
