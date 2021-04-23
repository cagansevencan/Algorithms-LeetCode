import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxScoreFromRemStones1753Version2 {
    public int maximumScore(int a, int b, int c) {
        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a,Integer b){
                return b - a;
            }
        });
        pq.offer(a);
        pq.offer(b);
        pq.offer(c);

        while(true){
            int x = pq.poll();
            int y = pq.poll();
            if(x == 0 || y == 0){
                break;
            }
            max++;
            pq.offer(x-1);
            pq.offer(y-1);
        }
        return max;
    }
}
