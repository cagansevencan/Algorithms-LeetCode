
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class IntersectionTwoLinkedLists160 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


    public static void main(String[] args) {
        ListNode headA = new ListNode(4);;
        ListNode headB = new ListNode(5);;

        ListNode A1 = new ListNode(1);
        headA.next = A1;

        ListNode A2 = new ListNode(8);;
        A1.next = A2;

        ListNode A3 = new ListNode(4);;
        A2.next = A3;

        ListNode A4 = new ListNode(5);;
        A3.next = A4;

        ListNode B1 = new ListNode(6);;
        headB.next = B1;

        ListNode B2 = new ListNode(1);;
        B1.next = B2;



        ListNode pA = getIntersectionNode(headA, headB);
        if(pA!=null) {
            System.out.println(pA.val);
        }else{
            System.out.println("null");
        }
    }
}




