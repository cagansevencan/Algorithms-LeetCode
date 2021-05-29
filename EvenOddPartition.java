
//Linear in Time
//Constant in Space complexity

public class EvenOddPartition {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static void append(EvenOddPartition.ListNode head, int new_data)
    {
    /* 1. Allocate the Node &
       2. Put in the data
       3. Set next as null */
        EvenOddPartition.ListNode new_node = new EvenOddPartition.ListNode(new_data);
    /* 4. If the Linked List is empty, then make the
           new node as head */
        if (head == null)
        {
            head = new EvenOddPartition.ListNode(new_data);
            return;
        }

    /* 4. This new node is going to be the last node, so
         make next of it as null */
        new_node.next = null;

        /* 5. Else traverse till the last node */
        EvenOddPartition.ListNode last = head;
        while (last.next != null)
            last = last.next;

        /* 6. Change the next of last node */
        last.next = new_node;
        return;
    }


    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddDummy = new ListNode(-1);
        ListNode evenDummy = new ListNode(-1);

        ListNode oddTail = oddDummy;
        ListNode evenTail = evenDummy;

        int index = 0;
        ListNode curr = head;
        while (curr != null) {
            if (index % 2 == 0) {
                evenTail.next = curr;
                evenTail = curr;
            } else {
                oddTail.next = curr;
                oddTail = curr;
            }

            curr = curr.next;
            index++;
        }

        evenTail.next = oddDummy.next;
        oddTail.next = null;

        return evenDummy.next;
    }

    public static void main(String[] args) {

        EvenOddPartition ob = new EvenOddPartition();
        EvenOddPartition.ListNode head = new EvenOddPartition.ListNode(1);
        append(head, 2);
        append(head, 3);
        append(head, 4);
        oddEvenList(head);
    }
}
