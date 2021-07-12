import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestToOrigin973 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> closest = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] sec) {
                return calculateDistance(sec) - calculateDistance(first);
            }
        });

        for(int[] point : points){
            closest.add(point);
            if(closest.size() > k){
                closest.poll();
            }
        }
        int [][] results = new int[k][2];
        while(k > 0){
            results[--k] = closest.poll();
        }
        return results;
    }

    private int calculateDistance(int [] point){
        return point[0] * point[0] + point[1] * point[1];
    }

}
