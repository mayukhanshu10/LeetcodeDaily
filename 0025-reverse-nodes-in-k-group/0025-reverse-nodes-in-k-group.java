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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head, kthNode = null, nextNode = null, prev = null;
        
        while(temp!=null){
            kthNode = findKthNode(temp,k);
            
            
            if(kthNode == null){
                if(prev!=null){
                    prev.next=temp;
                }
                break;
            }
            
            nextNode = kthNode.next;
            kthNode.next=null;
            reverse(temp);
            if(temp==head){ //Means first K groups
                head = kthNode;
            }else{
                prev.next=kthNode;
            }
            prev = temp;
            temp=nextNode;
        }
        
        return head;
    }
    
    
    
    private ListNode findKthNode(ListNode temp, int k){
        k -=1;
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }
    
    private ListNode reverse(ListNode head){
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