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
    private static Map<TreeNode, Integer> map;
    private static int max;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        map=new HashMap<>();
        
        map.put(null,-1);
        annotate(root,null);
        max=-1;
        for(Integer d: map.values())
             max=Math.max(max,d);
        return traverse(root);
        
    }
    
    public void annotate(TreeNode cur, TreeNode parent){
        if(cur==null) return;
        map.put(cur,map.get(parent)+1);
       
        annotate(cur.left,cur);
        annotate(cur.right,cur);
    }
    public TreeNode traverse(TreeNode root){
        if(root==null) return null;
        if(map.get(root)==max) return root;
        TreeNode L=traverse(root.left);
        TreeNode R=traverse(root.right);
        if(L!=null&&R!=null) return root;
        if(L!=null) return L;
        if(R!=null) return R;
        return null;
        
    }
}
