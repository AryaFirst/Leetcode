class Solution {
    public Node insert(Node head, int insertVal) {
        if(head==null) return new Node(insertVal,null);
        Node cur=head;
        Node presm=head,laNode=head;
        int small=head.val, large=head.val;
        while(true){
            if(cur.val<cur.next.val){
            if(cur.val<=insertVal&&insertVal<=cur.next.val){
                
                cur.next=new Node(insertVal,cur.next);
                return head;
                
            }
                else 
                    cur=cur.next;
            }else if (cur.val>cur.next.val){
                if(cur.val<=insertVal||cur.next.val>=insertVal)
                {
                    cur.next=new Node(insertVal,cur.next);
                    return head;
                }else 
                    cur=cur.next;
            }
            else{
                if(cur.next==head){
                    cur.next=new Node(insertVal, cur.next);
                    return head;
                }
                else
                    cur=cur.next;
            }
        }
       
    }
}
