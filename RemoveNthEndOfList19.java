public class RemoveNthEndOfList19 {
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
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        //Move first to end while maintaining the gap
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }



    public static void main(String[] args) {
        ListNode A1 = new ListNode(1);

        ListNode A2 = new ListNode(2);
        A1.next = A2;

        ListNode A3 = new ListNode(3);
        A2.next = A3;

        ListNode A4 = new ListNode(4);
        A3.next = A4;

        ListNode A5 = new ListNode(5);
        A4.next = A5;

        ListNode p =  removeNthFromEnd(A1, 2);
    }

}
