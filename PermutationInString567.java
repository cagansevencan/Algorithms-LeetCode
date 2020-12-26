import java.util.Arrays;

public class PermutationInString567 {
    public static boolean checkInclusion(String s1, String s2) {
        int[] a = new int[26];
        for(int i =0; i < s1.length(); i++){
            a[s1.charAt(i)-'a'] += 1;
        }

        int start =0;
        for(int i=0; i < s2.length(); i++){
            char c = s2.charAt(i);
            if(a[c-'a'] >0){
                a[c-'a'] = a[c-'a'] - 1;
                if((i-start+1) ==s1.length())
                    return true;
            }else{
                //We want to move the start pointer to be after 'a' so we are not including 'a' twice in our sliding window
                while(start!=i && s2.charAt(start)!= c){
                    a[s2.charAt(start) - 'a'] +=1;
                    //We increment start pointer until we reach value of start that doesn't contain c
                    start++;
                }
                if(s2.charAt(start) == c)
                    start++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        Boolean b = checkInclusion(s1, s2);
        System.out.println(b);
    }

}
