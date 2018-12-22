//time O(N^2)
//space O(1)

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res=nums[0]+nums[1]+nums[2];
        //
        //int test=Math.abs(res+1);
       // System.out.println(test);
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int num1=nums[i];
            int start=i+1;
            int end=nums.length-1;
            while(start<end){
                int sum=num1+nums[start]+nums[end];
                if(sum==target)
                    return sum;
                else if (sum<target)
                {
                    start++;
                    
                 if(Math.abs(sum-target)<Math.abs(res-target))
                     res=sum;
                    
                }else {
                    end--;
                 if(Math.abs(sum-target)<Math.abs(res-target))
                     res=sum;
                }
            }
        }
        return res;
    }
}
