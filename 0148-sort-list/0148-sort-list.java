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
    public ListNode sortList(ListNode head) {
        
        return merge(head);
    }
    
    private ListNode findMiddle(ListNode head){
        
        //No Need to check head == null || head.next == null , cauz it is check prior only in merge before                 calling findMiddle
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    
    private ListNode merge(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode middle = findMiddle(head);
        
        ListNode leftHead = head;
        ListNode rightHead = middle.next;
        middle.next = null;
        
        leftHead = merge(leftHead);
        rightHead = merge(rightHead);
        return mergeList(leftHead,rightHead);
        
    }
    
    private ListNode mergeList(ListNode firstNode, ListNode secondNode){
        ListNode dNode = new ListNode(-1);
        ListNode temp = dNode;
        
        while(firstNode!=null && secondNode!=null){
            if(firstNode.val<secondNode.val){
                temp.next = firstNode;
                temp=firstNode;
                firstNode = firstNode.next;
            }
            else{
                temp.next = secondNode;
                temp=secondNode;
                secondNode = secondNode.next;
            }
        }
        
        if(firstNode != null){
            temp.next = firstNode;
        }
        if(secondNode !=null){
            temp.next = secondNode;
        }
        
        return dNode.next;
    }
}