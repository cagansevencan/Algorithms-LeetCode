import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {

    class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

        private int capacity;
        Node evictionQueueHead;
        Node evictionQueueTail;
        Map<Integer, Node> nodes;

        public LRUCache146(int capacity) {
            this.capacity = capacity;
            nodes = new HashMap<Integer, Node>();
        }

        private void evict(Node node){
            if(node.prev != null){
                node.prev.next = node.next;
            }
            if(node.next != null){
                node.next.prev = node.prev;
            }
            if(node == evictionQueueTail){
                evictionQueueTail = evictionQueueTail.prev;
            }
            if(node == evictionQueueHead){
                evictionQueueHead = evictionQueueHead.next;
            }
        }

        private void addToEvictionQueue(Node node){
            if(evictionQueueTail == null){
                evictionQueueTail = evictionQueueHead = node;
                return;
            }
            evictionQueueTail.next = node;
            node.prev = evictionQueueTail;
            node.next = null;
            evictionQueueTail = evictionQueueTail.next;
        }


        public int get(int key) {
           if(!nodes.containsKey(key)){
               return -1;
           }
           Node node = nodes.get(key);
           evict(node);
           addToEvictionQueue(node);
           return node.value;
        }

        public void put(int key, int value) {
            //If there's no more space in list
            if(!nodes.containsKey(key) && nodes.size() >= capacity){
                //We need to evict head of queue first.
                nodes.remove(evictionQueueHead.key);
                evict(evictionQueueHead);
            }

            Node node = null;
            if(nodes.containsKey(key)){
                evict(nodes.get(key));
                node = nodes.get(key);
                node.value = value;
            }else{
                node = new Node(key, value);
                nodes.put(key, node);
            }
            addToEvictionQueue(node);
        }


    public static void main(String[] args) {
        LRUCache146 LRUCache = new LRUCache146(2);
        LRUCache.put(1,1);
        LRUCache.put(2,2);
        LRUCache.get(1);
        LRUCache.put(3,3); //LRU key was 2, evicts key 2 cache is {1=1, 3=3}
        LRUCache.get(2); // returns -1 (not found)
        LRUCache.put(4,4); //LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        LRUCache.get(1); // returns -1 (not found)
        LRUCache.get(3); // return 3
        LRUCache.get(4); // return 4
    }
}
