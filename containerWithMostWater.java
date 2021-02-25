public class containerWithMostWater {
    public static int maxArea(int[] height) {
        int maxArea = 0, l = 0, r = height.length - 1;
        while(l < r){
            maxArea = Math.max(maxArea, Math.min(height[1], height[r]) * (r-1));
            if(height[1] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }




    public static void main(String[] args) {
        int[] height = {1,3,6,2,5,4,8,3,2};
        int max = maxArea(height);
        System.out.println(max);
    }
}
