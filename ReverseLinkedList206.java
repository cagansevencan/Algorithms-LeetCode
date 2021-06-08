public class ReverseLinkedList206 {
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

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null){
           ListNode nextTemp = curr.next;
           curr.next = prev;
           prev = curr;
           curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode A1 = new ListNode(1);

        ListNode A2 = new ListNode(8);
        A1.next = A2;

        ListNode A3 = new ListNode(4);
        A2.next = A3;

        ListNode A4 = new ListNode(5);
        A3.next = A4;

        ListNode lastNode;
        lastNode = reverseList(A1);
    }
}
