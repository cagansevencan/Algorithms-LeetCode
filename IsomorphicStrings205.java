import java.util.HashMap;

public class IsomorphicStrings205 {
    public static boolean isIsomorphic(String s, String t) {
         HashMap<String, String> iso = new HashMap<>();
            if(s.length() != t.length()){
                return false;
            }
            String s1;
            String t1;
            String v;
            for(int i =0; i < s.length(); i++){
                s1 = s.substring(i, i+1);
                t1 = t.substring(i, i+1);

                if(!iso.containsKey(s1) && !iso.containsValue(t1) ){
                    iso.put(s1, t1);
                }else{
                    v= iso.get(s1);
                    if(v == null || !v.equals(t1)){
                        return false;
                    }
                }
            }
            return true;
    }

    public static void main(String[] args) {
        String s1 = "badc";
        String t1 = "baba";
        isIsomorphic(s1, t1);
    }
}
