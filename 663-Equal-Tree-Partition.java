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
    LinkedList<Integer> ls;
    public boolean checkEqualTree(TreeNode root) {
        ls=new LinkedList<Integer>();
        int total=sum(root);
        ls.removeLast();
        if(total%2==0){
            for(int s:ls)
                if(s==total/2)
                    return true;
        }
        return false;
    }
    public int sum(TreeNode root){
        if(root==null) return 0;
        ls.add(sum(root.left)+sum(root.right)+root.val);
        return ls.get(ls.size()-1);
    }
}663. Equal Tree Partition
