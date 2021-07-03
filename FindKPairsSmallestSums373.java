import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsSmallestSums373 {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new LinkedList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] - b[0] + a[1] - b[1]));

        if (nums1 == null
                || nums2 == null
                || k == 0
                || nums1.length == 0
                || nums2.length == 0) {
            return result;
        }

        for(int i = 0; i < nums1.length; i++){
            queue.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while(!queue.isEmpty() && k > 0){
            int [] temp = queue.poll();
            int index2 = temp[2];
            List<Integer> list = new LinkedList<>();
            list.add(temp[0]);
            list.add(temp[1]);
            result.add(list);
            k--;
            if(index2 + 1 < nums2.length){
                queue.offer(new int []{temp[0], nums2[index2 + 1], index2 +1});
            }
        }
        return result;
    }

    public static void main(String[] args) {
       int[] num1 = {1,7,11};
       int[] num2 = {2,4,6};
       int k =3;
       kSmallestPairs(num1, num2, 3);
    }
}
