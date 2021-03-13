import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class MinValidParant1249 {

        //1 - Identify all indexes that should be removed
        //2 - Build a new string with removed indexes
        // Use Stack
        public static String minRemoveToMakeValid(String s) {
            Set<Integer> indexesToRemove = new HashSet<>();
            Deque<Integer> stack = new ArrayDeque<>();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                }
                if (s.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        indexesToRemove.add(i);
                    } else {
                        stack.pop();
                    }
                }
            }

            // Put any indexes remaining on stack into the set
            while (!stack.isEmpty()) {
                indexesToRemove.add(stack.pop());
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if(!indexesToRemove.contains(i)){
                    sb.append(s.charAt(i));
                }
            }
            return sb.toString();
        }

        //Complexity Analysis:
        // Time: O(n)
        // Space: O(n), where n is the length of the input string

        //When checking your own implementation, watch out for
        // any O(n) library calls inside loops, as these would make your solution O(n^2)

        public static void main(String[] args) {
            String s = minRemoveToMakeValid("L(e)e(t)c)o)(d)e");
            System.out.println(s);
        }
    }

