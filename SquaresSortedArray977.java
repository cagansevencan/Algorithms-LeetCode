import java.util.Arrays;

public class SquaresSortedArray977 {
    public static int[] sortedSquares(int[] nums) {
        int l = 0;
        int k = nums.length-1;
        int r = nums.length-1;

        int[] result = new int[nums.length];

            while(l <= r) {
                if (Math.abs(nums[l]) >= Math.abs(nums[r])) {
                    result[k--] = (int) Math.pow(nums[l], 2);
                    l++;
                } else {
                    result[k--] = (int) Math.pow(nums[r], 2);
                    r--;
                }
            }
        return result;
    }

    public static void main(String[] args) {
        int[] n = sortedSquares(new int[] {-10, -5, 1, 2, 4, 7});
        System.out.println(Arrays.toString(n));
    }

}
