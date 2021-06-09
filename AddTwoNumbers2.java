

public class AddTwoNumbers2 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode dummyHead = new ListNode(0);
       ListNode p = l1, q = l2, curr = dummyHead;
       int carry = 0;
       while (p != null || q != null){
           int x = (p != null) ? p.val : 0;
           int y = (q != null) ? q.val : 0;
           int sum = carry + x + y;
           carry = sum /10;
           curr.next = new ListNode(sum % 10);
           curr = curr.next;
           if( p != null) {
               p = p.next;
           }
           if(q != null){
               q = q.next;
           }
       }if(carry > 0){
           curr.next = new ListNode(carry);
        }
       return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode A1 = new ListNode(2);

        ListNode A2 = new ListNode(9);
        A1.next = A2;

        ListNode A3 = new ListNode(3);
        A2.next = A3;

        ListNode B1 = new ListNode(5);

        ListNode B2 = new ListNode(6);
        B1.next = B2;

        ListNode B3 = new ListNode(8);
        B2.next = B3;

        ListNode C1 = addTwoNumbers(A1, B1);
    }
}
