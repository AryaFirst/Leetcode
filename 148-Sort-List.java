/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
       
        ListNode fast=head;
        ListNode slow=head;
        //1-2-3-4
        while(fast!=null&&fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode l2=sortList(slow.next);
        slow.next=null;
        ListNode l1=sortList(head);
        return merge(l1,l2);
        
    }
    public ListNode merge(ListNode l1, ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head=new ListNode (-1);
        ListNode cur=head;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
                cur=cur.next;
            }else{
                 cur.next=l2;
                l2=l2.next;
                cur=cur.next;
            }
        }
        if(l2!=null)
            cur.next=l2;
        if(l1!=null)
            cur.next=l1;
        return head.next;
        
        
        
    }
}148. Sort List
