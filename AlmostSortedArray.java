import java.util.ArrayList;
import java.util.PriorityQueue;

public class AlmostSortedArray {
    public static ArrayList<Integer> sortList(Integer[] almostSortedList, int m) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < m; i++) {
            minHeap.offer(almostSortedList[i]);
        }

        for (int i = 0; i < almostSortedList.length; i++) {
            minHeap.offer(almostSortedList[i]);
            result.add(minHeap.poll());
        }

        while (minHeap.peek() != null) {
            result.add(minHeap.poll());
        }

        return result;
    }
}
