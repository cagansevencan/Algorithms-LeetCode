import java.util.HashSet;

public class LongestPalindromeSubs {
    private int start, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;
        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i);   //assume odd length
            extendPalindrome(s, i, i + 1); //assume even length.
        }
        return s.substring(start, start + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            start = j + 1;
            maxLen = k - j - 1;
        }
    }
}


