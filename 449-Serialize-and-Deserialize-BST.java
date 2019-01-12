/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static String SEP=",";
    private static Stack<TreeNode> stack;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return null;
       stack=new Stack<>();
       String res="";
       stack.push(root);
        while(stack.size()!=0){
            TreeNode cur=stack.pop();
            res=res+cur.val+SEP;
            if(cur.right!=null) stack.push(cur.right);
            if(cur.left!=null) stack.push(cur.left);
        }
      return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null) return null;
       String [] d=data.split(SEP);
        Queue<Integer> queue=new LinkedList<>();
        for(String str:d)
            queue.add(Integer.parseInt(str));
       TreeNode root=helper (queue);
       return root;
      
    }
    public TreeNode helper(Queue<Integer> queue ){
        if(queue.size()==0) return null;
        TreeNode root=new TreeNode(queue.poll());
        Queue<Integer> little=new LinkedList<>();
        while(queue.size()>0&&queue.peek()<root.val){
            little.offer(queue.poll());
        }
        root.left=helper(little);
        root.right=helper(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
