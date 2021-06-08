import java.util.HashSet;
import java.util.Set;

public class IntersectionTwoLinkedLists160HashTable {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        //Traverse thru B and store its nodes
        while(headB != null){
            visited.add(headB);
            headB = headB.next;
        }
        while(headA != null){
            if(visited.contains(headA)){
                return headA;
            }
            headA = headA.next;
        }
        return null;
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

        B2.next = A2;

    }
}
