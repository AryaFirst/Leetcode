class Solution {
    public int minSubArrayLen(int s, int[] nums) {
   int i=0,j=0,res=Integer.MAX_VALUE,sum=0;
        while(j<=nums.length-1){
            sum+=nums[j++];
            while(sum>=s&&j>i){
                res=Math.min(res,j-i);
                sum-=nums[i++];
                
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
