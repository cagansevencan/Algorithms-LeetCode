import java.util.Arrays;

public class TwoSumLessThanK1099 {
    //Two Pointers Approach
    //Time - O(nlogn) to sort the array. Two pointer approach is O(n),
    //hence the complexity would be linear if the input is sorted.
    //Space - O(logn) to O(n). depending on the implementation of the sorting algo
    public static int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        int max = -1;
        while(l < r){
            if(nums[l] > k/2){
                return max;
            }

            int sum = nums[l] + nums[r];
            if(sum < k){
                max = Math.max(max, sum);
                l++;
            }else{
                r--;
            }
        }
        return max;
    }

    public static int twoSumLessThanKBinaryApproach(int[] nums, int k) {
        int max = -1;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int idx = Arrays.binarySearch(nums, i + 1, nums.length, k - nums[i] - 1);
            int j = (idx >= 0 ? idx : ~idx);
            if(j == nums.length || nums[j] > k - nums[i] - 1){
                j--;
            }
            if(j > i){
                max = Math.max(max, nums[i] + nums[j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {34,23,1,24,75,33,54,8};
        int n = twoSumLessThanK(nums, 60);
        int n2 = twoSumLessThanKBinaryApproach(nums, 60);
        System.out.println(n);
        System.out.println(n2);
    }
}
