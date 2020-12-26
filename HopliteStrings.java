import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HopliteStrings {
     public static String reorganizeString(String S){
         HashMap<Character, Integer> map = new HashMap<>();
         int max = 0;
         int n = S.length();
         for(int i=0; i< n; i++){
             char c = S.charAt(i);
             int count = map.getOrDefault(c, 0)+1;
             map.put(c, count);
             if(count>max)
                 max = count;
         }
         if(max > (S.length()+1)/2){
             return "";
         }
         //Elements in the priority queue is the entries from the map, entry set of the map
         PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b) -> (
                 b.getValue() - a.getValue()
                 ));  //Declaring a Max Heap in Java
         pq.addAll(map.entrySet()); //Add the whole EntrySet in the map to the priority queue

         StringBuilder sb = new StringBuilder();

         while (!pq.isEmpty()){
             Map.Entry<Character, Integer> first = pq.poll(); //Get the first
             sb.append(first.getKey()); //Append the character of that into the string

             if(!pq.isEmpty()){
                 Map.Entry<Character, Integer> second = pq.poll();
                 sb.append(second.getKey());

                 first.setValue(first.getValue()-1); //Setting value again since we used it
                 if (first.getValue()>0){
                     pq.add(first);
                 }
                 second.setValue(second.getValue()-1);
                 if(second.getValue()>0){
                     pq.add(second);
                 }
             }
         }
         return sb.toString();
     }

     //time: O(NlogA) => 0(N) where A is the size of the alphabet
    // A would be the max size of the hash map, max size of our queue.
    // We are adding everything in the map to our queue
    //space: O(A) => O(1)

    public static void main(String[] args) {
        String n = reorganizeString("aaaaabbbc");
        System.out.println();
    }

}
