public class JianZhi52 {
}
class ListNode{
    ListNode next;
}
class Solution52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headB == null || headA == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}