import java.util.HashSet;

public class ArraysAndStrings {

    //Implement an algo to determine if a string has all unique chars.
    public static boolean isUniqueUsingMap(String word){
        if(word.length() > 128) return false; //ASCII values atmost have 128 unless 
                                              // it is extended

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

    public static boolean isUniqueChars(String str){
        if(str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i);
            if(char_set[val]) { //If we already found it
                return false;
            }
            char_set[val] = true;
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
    public static String stringBuilder(String[] words){
        StringBuilder sentence = new StringBuilder();
        for(String w : words){
            sentence.append(w);
        }
        return sentence.toString();
    }

    public static void main(String[] args) {
        String s = "alibzr";
        //boolean v = isUniqueUsingMap(s);
        boolean v = isUniqueChars(s);
        System.out.println(v);
    }


}
