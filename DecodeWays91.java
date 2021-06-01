import java.util.HashMap;
import java.util.Map;

//RECURSIVE APPROACH

//Time: O(n)  mostly 1 recursive call per index - if the memo seen the index before we can return it
//Space: O(n) - n is the lenght of string

public class DecodeWays91 {
    static Map<Integer, Integer> memo = new HashMap<>();

    public static int numDecodings(String s) {

    return recursiveWithMemo(0, s);
    }

    private static int recursiveWithMemo(int i, String s) {
        if(memo.containsKey(i)){
            return memo.get(i);
        }
        //if the index is equal to length of the string, we know that we hit the end
        // and there's no more solutions
        if(i == s.length()){
            return 1;
        }
        //Nothing should start with 0
        if(s.charAt(i) == '0'){
            return 0;
        }
        //if we are at the last value of the array, there is only 1 way
        if(i == s.length()- 1){
            return 1;
        }
        // whatever is 1 value later than me
        int answer = recursiveWithMemo(i +1, s);
        //we have 2 digit encoding to use, so add that recursive call to the answer
        if(Integer.parseInt(s.substring(i, i+2)) <= 26){
        answer += recursiveWithMemo(i+2, s);
        }
        memo.put(i, answer);
        return answer;
    }

    public static void main(String[] args) {
        String test = "226";
        int num = numDecodings(test);
        System.out.println(num);
    }
}
