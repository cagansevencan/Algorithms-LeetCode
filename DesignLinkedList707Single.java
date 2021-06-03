//Implementing Singly Linked List
public class DesignLinkedList707Single{
    //COMPLEXITY
      //Time complexity: O(1) for addAtHead. O(k) for get, addAtIndex,
    // and deleteAtIndex, where kk is an index of the element to get, add or delete.
      // O(N) for addAtTail.
   // Space complexity: O(1) for all operations.

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    class MyLinkedList {
        int size;
        //sentinel node as pseudo head
        ListNode head;

        /** Initialize your data structure here. */
        public MyLinkedList() {
           size = 0;
           head = new ListNode(0); //sentinel
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            // if index is invalid
            if (index < 0 || index >= size) return -1;

            ListNode curr = head;

            for(int i = 0; i < index+1; ++i){
                curr = curr.next;
            }
            return curr.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
        addAtIndex(0, val);
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
        //If the index is greater than length, then node will not be inserted
            if(index > size) return;

        //Or if the Index is negative, node will be inserted at head
        if(index < 0) index = 0;

        ++size;
        //find predecessor of the node to be added
        ListNode pred = head;
        for(int i = 0; i < index; i++){
            pred = pred.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next  = toAdd;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            //If the index is greater than length, then node will not be inserted
            if(index >= size || index < 0) return;

            //Or if the Index is negative, node will be inserted at head

            size--;
            ListNode pred = head;
            for(int i = 0; i < index; ++i){
                pred = pred.next;
            }
            //deleting pred.next
            pred.next = pred.next.next;

        }
    }


}
