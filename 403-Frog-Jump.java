class Solution {
    private static int [] stones;
    int [][]memo;
    public boolean canCross(int[] stones) {
        int f_index=stones.length-1;
        this.memo=new int[stones.length][stones.length];
        for(int []row:memo)
            Arrays.fill(row,-1);
        this.stones=stones;
        return dfs(0, 1, f_index);
    }
    public boolean dfs(int num, int step, int target){
        int pos=find(num+step);
        if(pos==target) return true;
        if(pos!=-1){
            boolean b1, b2, b3;
        if(memo[pos][step+1]!=-1)
            b1=memo[pos][step+1]==1?true:false;
        else
        {
            b1=dfs(num+step, step+1, target);
             memo[pos][step+1]=b1?1:0;
        }
        if(memo[pos][step]!=-1)
            b2=memo[pos][step]==1?true:false;
        else
        {
            b2=dfs(num+step, step, target);
             memo[pos][step]=b2?1:0;
        }
        b3=false;
        if(step>1){
             if(memo[pos][step-1]!=-1)
            b3=memo[pos][step-1]==1?true:false;
            else
        {
            b3=dfs(num+step, step-1, target);
             memo[pos][step-1]=b3?1:0;
        }
      
        }
             return b1||b2||b3;
          
       
        }
        return false;
    }
    public int find(int target){
        int res=-1;
        int i=0;
        int j=stones.length-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(stones[mid]<target)
                i=mid+1;
            else if(stones[mid]>target)
                j=mid-1;
            else
                return mid;
        }
        return res;
    }
}403
