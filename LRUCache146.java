import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache146 {
    //Using LinkedHashMap
    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        //Params:
        //eldest – The least recently inserted entry in the map,
        // or if this is an access-ordered map, the least recently accessed entry.
        // This is the entry that will be removed it this method returns true.
        // If the map was empty prior to the put or putAll invocation resulting in this invocation,
        // this will be the entry that was just inserted; in other words,
        // if the map contains a single entry, the eldest entry is also the newest.

        //Returns:
        //true if the eldest entry should be removed from the map; false if it should be retained.

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
            return size() > capacity;
        }

    }
}
