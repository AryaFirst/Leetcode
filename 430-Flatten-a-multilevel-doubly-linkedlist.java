/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
       Node cur=head;
       while(cur!=null){
           while(cur!=null&&cur.child==null)
               cur=cur.next;
           if(cur==null) return head;
           Node next=cur.next;
           Node child=cur.child;
           cur.next=child;
           cur.next.prev=cur;
           cur.child=null;
           Node tmp=child;
           while(tmp.next!=null){
               tmp=tmp.next;
           }
           if(next!=null)
           {
               tmp.next=next;
               next.prev=tmp;
           }
           cur=cur.next;
       }
        return head;
    }
    
}
