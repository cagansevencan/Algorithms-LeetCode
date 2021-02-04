import java.util.HashSet;

//Time Complexity is O(n), where n is the length of the string
// Space is O(1) for the char set, O(n) for HashSet
// In the case we don't assume the char set is fixed, then the complexity would be O(c) space and O(min(c,n)) or O(c) time, where c is the size of the char set.
// We can also reduce space usage by a factor of eight by using a bit vector. 
// We will assume, in the below code, that the string only
// uses the lowecase ketters a through z. This will allow us to use a just a single int. 

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

    public static boolean isUniqueCharsVectors(String str){
        if(str.length() > 128) return false;
        int checker = 0;
        for(int i = 0; i < str.length(); i++){
        int strVal = str.charAt(i);
        int val = strVal - 'a';
        if((checker & (1 << val)) > 0){
            return false;
        }
        checker |= (1 << val);
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
        String s = "alrirbz";
        //boolean v = isUniqueUsingMap(s);
        boolean v = isUniqueCharsVectors(s);
        System.out.println(v);
    }


}
