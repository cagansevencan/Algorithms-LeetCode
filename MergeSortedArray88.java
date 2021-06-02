import java.util.Arrays;

public class MergeSortedArray88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 =m-1, p2 = n-1;

        //Compare elements
        for (int p = m+n-1; p >= 0 ; p--){
            if(p2< 0){
                break;
            }

            if(p1 >= 0 && (nums1[p1] > nums2[p2])){
                nums1[p] = nums1[p1--];
            }else{
                nums1[p] = nums2[p2--];
            }
        }
    }

    public static void main(String[] args) {
    int[] array1 = {1,2,3,0,0,0};
    int[] array2 = {2,5,6};
    int n = 3;
    int m = 3;
    merge(array1, m, array2, n);

    System.out.println(Arrays.toString(array1));
    }
}
