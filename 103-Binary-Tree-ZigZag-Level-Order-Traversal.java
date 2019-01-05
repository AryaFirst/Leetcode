/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List <List<Integer>>res=new LinkedList<>();
        traverse(res, root,1);
        return res;
    }
    public void traverse(List<List<Integer>> res, TreeNode root, int level){
        if (root==null) return;
        
        if(res.size()<level){
            List<Integer> tmp=new LinkedList<>();
            res.add(tmp);
        }
        
        List<Integer> ll=res.get(level-1);
        if(level%2==1)
            ll.add(root.val);
        else
            ll.add(0, root.val);
        traverse(res,root.left,level+1);
        traverse(res,root.right,level+1);
    }
}
