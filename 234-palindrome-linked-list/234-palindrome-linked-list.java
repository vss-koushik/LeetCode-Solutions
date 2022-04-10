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
    public boolean isPalindrome(ListNode head) {
        ListNode left = head;
        ListNode right = head;
        ListNode curr = head;
        
        while(curr != null && curr.next != null){
            right = right.next;
            curr = curr.next.next;
        }
        
        right = reverseList(right);
        
        while(right != null){
            if(left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        
        return true;
    }
    
    private ListNode reverseList(ListNode head){
        if(head == null || head.next == null)
            return head;
        //ListNode prev = null;
        ListNode curr = head;
        ListNode Next = head.next;
        
        while(Next != null){
            curr.next = Next.next;
            Next.next = head;
            head = Next;
            
            
            Next = curr.next;
        }
        
        return head;
    }
}