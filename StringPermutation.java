import java.util.Arrays;
import java.util.HashSet;

public class StringPermutation {

     static String sort(String s){
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);

    }

    public static boolean isPermutation(String word, String word2){
        return sort(word).equals(sort(word2));
    }

    public static void main(String[] args) {
        String word1 = "";
        String word2 = " ";
        Boolean t = isPermutation(word1, word2);
        System.out.println(t);
    }


    
}
