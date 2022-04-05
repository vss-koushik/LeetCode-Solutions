/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        
        head = swapNodes(head, head.next);
        ListNode curr = head.next;
        
        while(curr != null && curr.next != null){
            curr.next = swapNodes(curr.next, curr.next.next);
            curr = curr.next.next;
        }
        return head;
    }
    
    private ListNode swapNodes(ListNode curr, ListNode Next){
        if(Next == null)
            return curr;
        
        curr.next = Next.next;
        Next.next = curr;
        return Next;
    }
}