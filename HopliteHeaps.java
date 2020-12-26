import java.util.Collections;
import java.util.PriorityQueue;

public class HopliteHeaps {
    public static int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(Integer i : stones){
            q.add(i);
            }
        while (q.size()>1) {
            int x = q.poll();
            int y = q.poll();
            if (x != y) {
                q.add((int) Math.abs(x - y));
            }
        }
            if(q.isEmpty())
                return 0;
            return q.poll();
    }

    public static void main(String[] args) {
        int [] stones = {2};
        int n = lastStoneWeight(stones);
         System.out.println(n);
    }
}

