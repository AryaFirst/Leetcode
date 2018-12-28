//1. recursive:
class Solution {
    public int countNodes(TreeNode root) {
        
        int h=height(root);
        return h<0?0:height(root.right)==h-1?(1<<h)+countNodes(root.right) :(1<<h-1)+countNodes(root.left);
    }
    public int height(TreeNode root){
        return root==null?-1:1+height(root.left);
        
    }
}

//2. iterative:
class Solution {
    public int countNodes(TreeNode root) {
        
        int h=height(root);
        int res=0;
        while(root!=null){
            h=height(root);
            if(height(root.right)==h-1){
                res+=(1<<h);
                root=root.right;
            }else{
                res+=(1<<h-1);
                root=root.left;
                
            }
        }
        return res;
    }
    public int height(TreeNode root){
        return root==null?-1:1+height(root.left);
        
    }
}
