import java.util.Stack;

public class MinStack155 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack155() {}

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop() {
        if(getMin() == top()) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
       return stack.peek();
    }

    public int getMin() {
       return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack155 minStack = new MinStack155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
    }
}
