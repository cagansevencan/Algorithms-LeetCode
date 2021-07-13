import java.util.Stack;

public class ValidateStackSeq946 {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = pushed.length;
        Stack<Integer> stack = new Stack<>();

        int j = 0;
        for(int x : pushed){
            stack.push(x);
            while (!stack.isEmpty() && j < N && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return j == N;
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};

    }
}
