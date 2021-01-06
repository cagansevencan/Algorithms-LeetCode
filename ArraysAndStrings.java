import java.util.HashMap;
import java.util.HashSet;

public class ArraysAndStrings {

    //Implement an algo to determine if a string has all unique chars.
    public static boolean isUnique(String word){

        HashSet<Character> map = new HashSet<>();
        for(char c: word.toCharArray()){
            if(!map.contains(c)) {
                map.add(c);
            }else{
                return false;
            }
        }
        return true;
    }


    public static String joinWords(String[] words){
        String sentence = "";
        for(String w : words){
            sentence = sentence + w;
        }
        return sentence;
    }
    public static String StringBuilder(String[] words){
        StringBuilder sentence = new StringBuilder();
        for(String w : words){
            sentence.append(w);
        }
        return sentence.toString();
    }

    public static void main(String[] args) {
        String s = "alibaba";
        boolean v = isUnique(s);
        System.out.println(v);
    }


}
