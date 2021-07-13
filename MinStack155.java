import java.util.Stack;

public class MinStack155 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<int[]> minStack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack155() {}

    public void push(int val) {
        stack.push(val);

        if(minStack.isEmpty() || val < minStack.peek()[0]){
            minStack.push(new int[]{val, 1});
        }else if(val == minStack.peek()[0]){
           minStack.peek()[1]++;
        }
    }

    public void pop() {
        if(stack.peek().equals(minStack.peek()[0])){
            minStack.peek()[1]--;
        }
        if(minStack.peek()[1] == 0){
             minStack.pop();
        }
        stack.pop();
    }

    public int top() {
       return stack.peek();
    }

    public int getMin() {
       return minStack.peek()[0];
    }

    public static void main(String[] args) {
        MinStack155 minStack = new MinStack155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        min = minStack.getMin(); // return -2
    }
}
