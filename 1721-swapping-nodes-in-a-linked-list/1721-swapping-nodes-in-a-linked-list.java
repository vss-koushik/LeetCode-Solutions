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
   /* public ListNode swapNodes(ListNode head, int k) {
        ListNode curr = head;
        for(int i = 1; i < k; i++)
            curr = curr.next;
        
        reverseList(curr.next);
        
        ListNode reverseNode = curr.next;
        
        for(int i = 1; i < k; i++){
            reverseNode = reverseNode.next;
        }
        
        
    }
    */
    public ListNode swapNodes(ListNode head, int k){
        
        //ListNode curr = head;
    
        ListNode left = head;
        
        for(int i = 1; i < k; i++){
            left = left.next;
        }
        
        ListNode curr = left;
        ListNode right = head;
        //System.out.println(left.val);
        while(curr.next != null){
            right = right.next;
            //System.out.println("preRight = ")
            curr = curr.next;
        }
        
        int temp = left.val;
        //preRight.val = left.val;
        left.val = right.val;
        right.val = temp;
        
        return head;
    }
}