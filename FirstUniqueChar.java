import java.util.HashMap;

public class FirstUniqueChar {

    public static int firstUniq(String s) {

        int frequencies [] = new int[256];

        for(int i = 0; i < s.length(); i++){
            char val = s.charAt(i);
            frequencies[val - 'a'] ++;
        }

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int index = s.charAt(i)-'a';
            if(frequencies[index] == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        int numb = firstUniq(s);
    }
}
