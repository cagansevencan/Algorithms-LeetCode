import java.util.Arrays;

public class Mismatch645 {
    public static int[] findErrorNums(int[] nums) {
        int[] output = new int[2];

        for(int i =0; i < nums.length; i++){
            if(nums[Math.abs(nums[i])-1] < 0){
                output[0] = Math.abs(nums[i]);
            }else{
                nums[Math.abs(nums[i])-1] = -1 * nums[Math.abs(nums[i])-1];
            }
        }

        for(int i =0; i < nums.length; i++){
            if(nums[i]>0){
                output[1]=i+1;
                break;
            }
        }

        return output;
    }
    public static void main(String[] args) {
         int[] n = {6,3,5,1,2,3};
         int[] res = findErrorNums(n);
        System.out.println(Arrays.toString(res));
    }
}
