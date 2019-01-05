

//

public class Solution {
    public void connect(TreeLinkNode root) {
        List<List<TreeLinkNode>> ls=new LinkedList<>();
        traverse(ls,root,1);
       
        
    }
    public void traverse(List<List<TreeLinkNode>> ls, TreeLinkNode root, int level){
        if(root==null) return;
        if(ls.size()<level){
            List<TreeLinkNode> tmp=new LinkedList<>();
            ls.add(tmp);
            
        }
        List<TreeLinkNode> collection=ls.get(level-1);
        if(collection.size()>0)
            collection.get(collection.size()-1).next=root;
        collection.add(root);
        traverse(ls,root.left,level+1);
        traverse(ls,root.right,level+1);
    }
}


//

public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        TreeLinkNode pre=root;
        TreeLinkNode cur=null;
        while(pre.left!=null){
            cur=pre;
            while(cur!=null){
                cur.left.next=cur.right;
                if(cur.next!=null)
                    cur.right.next=cur.next.left;
                cur=cur.next;
            }
            pre=pre.left;
        }
    }
}
