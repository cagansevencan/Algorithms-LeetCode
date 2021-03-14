import java.util.Arrays;

public class BestTimeSell121 {
    public static int maxProfit(int[] prices) {

        int j = 1;
        int profit = 0;
        int min = prices[0];

        while (j < prices.length) {
            int n2 = prices[j];
            if (n2 < min) {
                min = n2;
            }
            if (profit < n2 - min) {
                profit = n2 - min;
            }
            j++;
        }
        return profit;
    }

    public static void main(String[] args) {
        int n = maxProfit(new int[] {7,6,4,3,1});
        System.out.println(n);
    }
}
