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
    public ListNode reverseList(ListNode head) {
        ListNode h1 = null;
        ListNode h2 = head;
        
        while(h2!=null){
            ListNode temp = h2;
            h2=h2.next;
            temp.next = h1;
            h1 = temp;
        }
        
        return h1;
    }
}