public class OddEvenLinkedList328 {
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
    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode even = head;
        ListNode odd = head.next;

        ListNode oddHead = odd;

        while (odd != null && odd.next != null){
            even.next = odd.next;
            even = odd.next;
            odd.next = even.next;
            odd = even.next;
        }
        even.next = oddHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode dummyHead = new ListNode(0);

        ListNode A1 = new ListNode(1);
        dummyHead.next = A1;

        ListNode A2 = new ListNode(2);
        A1.next = A2;

        ListNode A3 = new ListNode(3);
        A2.next = A3;

        ListNode A4 = new ListNode(4);
        A3.next = A4;

        ListNode A5 = new ListNode(5);
        A4.next = A5;

        A5.next = null;

        oddEvenList(dummyHead);
    }
}
