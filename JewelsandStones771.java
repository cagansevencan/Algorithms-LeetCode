import java.util.HashSet;

public class JewelsandStones771 {
    //Time: O(N)
    //Space: O(N)
    public int numJewelsInStones(String jewel, String stone) {
        HashSet<Character> jewels = new HashSet<>();
        int count = 0;
        for(char c: jewel.toCharArray()){
            jewels.add(c);
        }
        for(char c: stone.toCharArray()){
            if(jewels.contains(c)){
                count++;
            }
        }
        return count;
    }
}
