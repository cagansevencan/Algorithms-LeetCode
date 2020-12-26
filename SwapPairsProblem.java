public class SwapPairsProblem {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public ListNode swapPairs(ListNode head) {
        //if list has no node or 1 node left
        if(head.next == null || head ==null){
            return head;
        }
        //Nodex to be swapped
        swapPairs(head.next.next);
        swap(head);
        return head;
    }

    public void swap(ListNode head){
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        firstNode.next = null;
        secondNode.next = head;
    }

    public static void append(ListNode head, int new_data)
    {
    /* 1. Allocate the Node &
       2. Put in the data
       3. Set next as null */
        ListNode new_node = new ListNode(new_data);
    /* 4. If the Linked List is empty, then make the
           new node as head */
        if (head == null)
        {
            head = new ListNode(new_data);
            return;
        }

    /* 4. This new node is going to be the last node, so
         make next of it as null */
        new_node.next = null;

        /* 5. Else traverse till the last node */
        ListNode last = head;
        while (last.next != null)
            last = last.next;

        /* 6. Change the next of last node */
        last.next = new_node;
        return;
    }


    public static void main(String[] args) {

        SwapPairsProblem ob = new SwapPairsProblem();
        ListNode head = new ListNode(1);
        append(head, 2);
        append(head, 3);
        append(head, 4);
    }
}
