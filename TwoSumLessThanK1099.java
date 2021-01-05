import java.util.Arrays;

public class TwoSumLessThanK1099 {
    //Two Pointers Approach
    //Time - O(nlogn) to sort the array. Two pointer approach is O(n),
    //hence the complexity would be linear if the input is sorted.
    //Space - O(1) - We dont declare any extra memory based on the inpput size.
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

    // Time - O(n + m), where m corresponds to the range of values in the input array.
    // Space - O(m) to count each value.

    public static int twoSumLessThanKCountingSortApproach(int[] nums, int k) {
        //We can leverage the fact that input number range is limited to 1 - 1000 and use counting sort
        //Then we can use the two pointers pattern to enumerate pairs in the 1..1000 range.

        // Algo:
        int max = -1;
        int[] count = new int[1001];
        for(int num : nums){
            count[num]++;
        }
        int lo = 1;
        int hi = 15;
        while(lo <= hi){
            if(lo + hi >= k || count[hi] == 0){
                hi--;
            }else{
                if(count[lo] > ( lo < hi ? 0 : 1)){ // If count[lo] is greater than 0 (when lo < hi), or 1 (when lo == hi)
                    max = Math.max(max, lo + hi);
                }
                lo++;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {1,6,2,8,5};
        int n = twoSumLessThanK(nums, 12);
        int n2 = twoSumLessThanKBinaryApproach(nums, 12);
        int n3 = twoSumLessThanKCountingSortApproach(nums, 12);
        System.out.println(n);
        System.out.println(n2);
        System.out.println(n3);
    }
}
