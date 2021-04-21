import java.util.PriorityQueue;

public class MaxScoreFromRemStones1753 {
    public int maximumScore(int a, int b, int c) {
        //We'll use a maxheap

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a1, b1) -> (b1 - a1));

        //store in MaxHeap
        maxHeap.add(a);
        maxHeap.add(b);
        maxHeap.add(c);

        int total = 0;
        while(maxHeap.size() > 1){
            //find first two max number
            int maxNum1 = maxHeap.remove();
            int maxNum2 = maxHeap.remove();

            //decrement both
            maxNum1--;
            maxNum2--;

            //only add in heap, if greater than 0
            if(maxNum1 > 0) maxHeap.add(maxNum1);
            if(maxNum2 > 0) maxHeap.add(maxNum2);

            //increase the score
            total++;
        }
        return total;
    }
}
