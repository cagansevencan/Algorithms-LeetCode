

public class MaxScore1753 {
    public static int maximumScore(int a, int b, int c) {
        if (a < b)
            return maximumScore(b, a, c);
        if (b < c)
            return maximumScore(a, c, b);
        return b == 0 ? 0 : 1 + maximumScore(a - 1, b - 1, c);
    }
    public static void main(String[] args) {
        int t = maximumScore(2,4,6);
        System.out.println("Output is : " + t);
    }
}
