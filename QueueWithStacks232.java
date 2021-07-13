import java.util.Stack;

public class QueueWithStacks232 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> secondStack = new Stack<>();

    private int front;
    /** Initialize your data structure here. */
    public QueueWithStacks232() {
    }

    /** Push element x to the back of queue. */
    public void push(int x) {

    if(stack.isEmpty()) {
        front = x;
    }
    stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(secondStack.isEmpty()) {
            while (!stack.isEmpty()) {
                secondStack.push(stack.pop());
            }
            secondStack.pop();
        }
        return secondStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(!secondStack.isEmpty()){
            return secondStack.peek();
        }
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty() && secondStack.isEmpty();
    }


}
