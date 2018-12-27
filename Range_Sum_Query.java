class NumArray {
    class segmentTreeNode{
        int start;
        int end;
        int sum;
        segmentTreeNode right, left;
        public segmentTreeNode(int start, int end){
            this.start=start;
            this.end=end;
            this.left=null;
            this.right=null;
            this.sum=0;
        }
    }
    
    segmentTreeNode root=new segmentTreeNode(0,0);
    public NumArray(int[] nums) {
        buildTree(root,0,nums.length-1,nums);
        
    }
    public segmentTreeNode buildTree(segmentTreeNode root, int start, int end, int[] nums){
        root.start=start;
        root.end=end;
        if(start>end) root=null;
        else if(start==end){
            root.sum=nums[start];
        }else{
        int mid=start+(end-start)/2;
        
        root.left=buildTree(new segmentTreeNode(start,mid),start,mid,nums);
        root.right=buildTree(new segmentTreeNode(mid+1,end),mid+1,end,nums);
        root.sum=root.left.sum+root.right.sum;
        }
        return root;
    }
    
    public void update(int i, int val) {
       update(root,i, val);
    }
    void update(segmentTreeNode root, int i, int val){
        if(root.start==root.end)
        {root.sum=val;}
        else{
            int mid=root.start+(root.end-root.start)/2;
            if(mid>=i)
                update(root.left,i,val);
            else
                update(root.right, i, val);
            
            root.sum=root.left.sum+root.right.sum;
        }
    }
    
    public int sumRange(int i, int j) {
        return sumRange(root, i,j);
    }
    public int sumRange(segmentTreeNode root, int i, int j){
        int mid=root.start+(root.end-root.start)/2;
        if(root.start==i&&root.end==j) return root.sum;
        if(j<=mid)
            return sumRange(root.left, i , j); 
        else if(i>mid)
            return sumRange(root.right, i, j);
        else
            return sumRange(root.left, i ,mid)+sumRange(root.right, mid+1, j);
        
    }
}
