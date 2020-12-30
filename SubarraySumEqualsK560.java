import java.util.Collections;
import java.util.HashMap;

public class SubarraySumEqualsK560 {
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        int i = 0;
        int count = 0;

        while(i < n){
            currSum += nums[i];

            if(currSum == k){
                count += 1;
            }
            if(map.containsKey(currSum-k)){
                count+= map.get(currSum-k);
            }

            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
            i += 1;
        }

            return count;
    }

    public static void main(String[] args) {
        int[] array = {1,4,7,2,-3,1,4,2};
        int n = subarraySum(array, 7);
        System.out.println(n);
    }
}
