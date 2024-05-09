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
        
        if(head == null || head.next==null){
            return true;
        }
        
        //Find the middle of LL
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;
        }
        
        ListNode secondHead = reverse(slow);
        ListNode curr=head;
        
        while(secondHead!=null){
            if(curr.val!=secondHead.val){
                return false;
            }
            curr=curr.next;
            secondHead = secondHead.next;
        }
        
        return true;
        
    }
    
    private ListNode reverse(ListNode head){
        ListNode h1=null, h2=head;
        
        while(h2!=null){
            ListNode temp = h2;
            h2=h2.next;
            temp.next=h1;
            h1=temp;
        }
        
        return h1;
        
    }
}