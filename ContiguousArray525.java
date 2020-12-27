import java.util.Arrays;
import java.util.HashMap;

//Time complexity : O(n) The entire array is traversed only once.
//Space complexity : O(n). Maximum size of the HashMap map will be \text{n}n, if all the elements are either 1 or 0.

public class ContiguousArray525 {
    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int max = 0;
        int count = 0;
        for(int i =0; i < nums.length; i++){
            count+= (nums[i] == 1 ? 1 : -1);
            if(map.containsKey(count)){
                max = Math.max(max, i-map.get(count));
            }else{
                map.put(count, i);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] array = {0, 0, 1, 0, 0, 0, 1, 1};
        int n = findMaxLength(array);
        System.out.println(n);
    }

}