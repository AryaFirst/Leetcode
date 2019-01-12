/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head=root;
        while(head!=null){
            TreeLinkNode nextHead=new TreeLinkNode(-1), tail=nextHead;
            for(TreeLinkNode node=head;node!=null;node=node.next){
                if(node.left!=null){
                    tail.next=node.left;
                    tail=tail.next;
                }
                if(node.right!=null){
                    tail.next=node.right;
                    tail=tail.next;
                }
            }
            head=nextHead.next;
        }
    }
}
