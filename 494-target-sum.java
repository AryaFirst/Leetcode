class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum=0;
        for(int num:nums)
            sum+=num;
        if(sum<S ||(sum+S)%2==1) return 0;
        return helper(nums, (sum+S)/2);
    }
    public int helper(int []nums, int target){
        int []dp=new int [target+1];
        dp[0]=1;
        for(int num:nums){
            for(int i=target;i>=num;i--)
                dp[i]+=dp[i-num];
        }
        return dp[target];
    }
}
