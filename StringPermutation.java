import java.util.Arrays;
import java.util.HashSet;

public class StringPermutation {


    static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);

    }

    //NlogN Version
    public static boolean isPermutation(String word, String word2) {
        return sort(word).equals(sort(word2));
    }


    //N running time
    public static boolean permutation(String word, String word2) {
        if (word.length() != word2.length()) {
            return false;
        }

        int[] letters = new int[128];
        for (int i = 0; i < word.length(); i++) {
            letters[word.charAt(i)]++;
        }

        for (int i = 0; i < word2.length(); i++) {
            letters[word2.charAt(i)]--;
            if (letters[word2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String word1 = "doge";
        String word2 = "goda";
        Boolean t = permutation(word1, word2);
        System.out.println(t);
    }
}