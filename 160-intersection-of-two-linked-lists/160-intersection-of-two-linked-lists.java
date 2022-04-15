/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//Solution using two pointers
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode hA = headA;
        ListNode hB = headB;
        
        while(hA != null && hB != null) {
            hA = hA.next;
            hB = hB.next;
        }
        
        ListNode newA = headA;
        ListNode newB = headB;
        
        while(hA != null) {
            hA = hA.next;
            newA = newA.next;
        }
        
        while(hB != null) {
            hB = hB.next;
            newB = newB.next;
        }
        
        while(newA != null && newB != null) {
            if(newA == newB) return newA;
            newA = newA.next;
            newB = newB.next;
        }
        
        return null;
    }
}



//Solution using HashSet
/*public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null)
            return headB;
        if(headB == null)
            return headA;
        
        HashSet<ListNode> set = new HashSet<ListNode>();
        ListNode temp = headA;
        
        while(temp != null){
            set.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while(temp != null){
            if(set.contains(temp))
                return temp;
            temp = temp.next;
        }
        ListNode nullNode = null;
        return nullNode;
    }
}*/