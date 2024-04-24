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
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        if(temp==null || temp.next==null){
            return head;
        }
        int count=0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        
        int mid= (count/2)+1;
        int counter = 0;
        temp=head;
        
        while(temp!=null){
            counter+=1;
            if(counter==mid){
                break;
            }
            temp=temp.next;
        }
        
        return temp;
    }
}