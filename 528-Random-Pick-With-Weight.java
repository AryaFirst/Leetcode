class Solution {
    Random random;
    int []sum;
    public Solution(int[] w) {
        this.random=new Random();
        
        for(int i=1;i<w.length;i++)
            w[i]+=w[i-1];
        this.sum=w;
        
    }
    
    public int pickIndex() {
        int index=random.nextInt(this.sum[this.sum.length-1])+1;
        int left=0;
        int right=this.sum.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(sum[mid]<index) left=mid+1;
            else if(sum[mid]>index)right=mid;
            else return mid;
        }
        return left;
        
    }
}
