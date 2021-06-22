import java.util.HashSet;

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
                count+= 1;
            }else{
                count -= 1;
            }
        }
        if(count % 2 == 0){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {

        Boolean b = isPalindromePermutation(new String("TTTTeneTTTT"));
        System.out.println(b);
    }

}
