import java.util.HashMap;

public class WordPattern {
        public static boolean wordPattern(String pattern, String s) {
            HashMap<Character, String> map_char = new HashMap();
            HashMap <String, Character> map_word = new HashMap();
            String[] words = s.split(" ");
            if (words.length != pattern.length())
                return false;
            for (int i = 0; i < words.length; i++) {
                char c = pattern.charAt(i);
                String w = words[i];
                if (!map_char.containsKey(c)) {
                    if (map_word.containsKey(w)) {
                        return false;
                    } else {
                        map_char.put(c, w);
                        map_word.put(w, c);
                    }
                } else {
                    if (!map_char.get(c).equals(w))
                        return false;
                }
            }
            return true;
        }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        boolean t = wordPattern(pattern, s);
        System.out.println(t);

    }
}
