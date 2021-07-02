import java.util.*;

public class TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> heapQ = new PriorityQueue<>(new MyComparator());
        for(Map.Entry<String, Integer> e:map.entrySet()){
            heapQ.offer(e);
        }
        List<String> result = new LinkedList<>();
        for(int i = 0; i <=k-1; i++){
            result.add(heapQ.poll().getKey());
        }
        return result;

    }

    static class MyComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            String word1 = o1.getKey();
            int freq1 = o1.getValue();
            String word2 = o2.getKey();
            int freq2 = o2.getValue();
            if(freq1!=freq2){
                return freq2 - freq1;
            }else{
                return word1.compareTo(word2);
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        List<String> result = new LinkedList<>();
        result = topKFrequent(words, k);
        System.out.println(result);
    }


}
