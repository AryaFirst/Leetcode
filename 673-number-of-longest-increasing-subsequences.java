class Solution {
    public int findNumberOfLIS(int[] nums) {
        int []len=new int [nums.length], cnt=new int [nums.length];
        int max=0,res=0;
        for(int i=0;i<nums.length;i++){
            len[i]=1;
            cnt[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(len[i]==len[j]+1){
                        cnt[i]+=cnt[j];
                    }
                    else if(len[i]<len[j]+1){
                        len[i]=len[j]+1;
                        cnt[i]=cnt[j];
                    }
                }
            }
            if(max<len[i]){
                res=cnt[i];
                max=len[i];
            }else if(max==len[i])
                res+=cnt[i];
        }
     return res;   
    }
}
