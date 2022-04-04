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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode left = dummy;
        ListNode right = head;
        
        for(int i = 0; i < n; i++)
            right = right.next;
        
        while(right != null){
            right = right.next;
            left = left.next;
        }
        
        left.next = left.next.next;
        
        return dummy.next;
    }
    /*
    [1,2,3,4,5,6,7], n = 3
    */
}