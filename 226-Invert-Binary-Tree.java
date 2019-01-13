class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        if(root.left==null&&root.right==null) return root;
        TreeNode tmp=invertTree(root.left);
        root.left=invertTree(root.right);
        root.right=tmp;
        return root;
    }
}
