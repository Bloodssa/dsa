package java_dsa_leetcode.stack;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> min;

    public MinStack() {
        this.stack = new Stack<>();
        this.min = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        // if the min stack is not empty and val is less than to the peek element of the min stack push it to change the peek
        if(min.isEmpty() || val <= min.peek()) {
            min.push(val);
        }
    }

    // if the pop element in the stack and the peek of min stack is the same then pop the element in the minstack
    public void pop() {
        if(stack.isEmpty()) return;
        int s = stack.pop();
        if(s == min.peek()) {
            min.pop();
        }
   }

    public int top() {
        return stack.peek();
    }

    // get the last element of the min which is the small value element
    public int getMin() {
        return min.peek();
    }
}

class Test {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top()); // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}

/**
 * Not optimal solution
 * Trash Solution
 */
class TimeLimitExceeds {

    private Stack<Integer> stack;

    public TimeLimitExceeds() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    /**
     * Initialize a new temp stack
     * pop all the element in the stack
     * for every element compare it to the init min
     * store the pop element in the temp stack
     * after getting the min element
     * push all the element int the temp stack to the main stack
     * although the time to get the stack would be O(n)
     * NOTE: Improve in the future
     */
    public int getMin() {
        Stack<Integer> temp = new Stack<>();
        int min = stack.peek();

        while (!stack.isEmpty()) {
            int t = temp.push(stack.pop());
            min = Math.min(min, t);
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        return min;
    }
}