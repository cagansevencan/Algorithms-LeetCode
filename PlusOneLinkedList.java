public class PlusOneLinkedList {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public static ListNode plusOne(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode notNine = sentinel;

        //find the rightmost non-nine digit
        while(head != null){
            if(head.val != 9){
                notNine = head;
            }
            head = head.next;
        }

        //increase this rightmost not-nine digits by 1
        notNine.val++;
        notNine = notNine.next;

        //set all the following nines to zeros
        while(notNine != null){
            notNine.val = 0;
            notNine = notNine.next;
        }

        return sentinel.val != 0 ? sentinel : sentinel.next;
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
         ListNode head = new ListNode(1);
         append(head, 4);
         append(head, 9);
         append(head, 3);
         append(head, 2);
         append(head, 9);
         append(head, 8);
         append(head, 9);

         head = plusOne(head);

    }
}
