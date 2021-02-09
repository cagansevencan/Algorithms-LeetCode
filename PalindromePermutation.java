import java.util.HashSet;
import java.util.Locale;

public class PalindromePermutation {
    //We dont have to, should not have to generate all permutations
    //Hash Table -> O(n)

    public static boolean isPalindromePermutation(String s){
        HashSet<Character> map = new HashSet<>();
        int count = 0;
        s = s.toLowerCase();
        for(char c: s.toCharArray()){
            if(!map.contains(c)) {
                map.add(c);
            }else{
                count += 2;
            }
        }
        if(count % 2 == 0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {

        Boolean b = isPalindromePermutation(new String("Tact Coa"));
        System.out.println(b);
    }

}
