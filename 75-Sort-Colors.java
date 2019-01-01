//your own, two scan;
class Solution {
    public void sortColors(int[] nums) {
        int i_zero=0,i_two=nums.length-1;
        while(i_zero<i_two){
            while(i_zero<i_two&&i_zero<nums.length&&nums[i_zero]==0)
                i_zero++;
            while(i_zero<i_two&&i_two>=0&&(nums[i_two]==2||nums[i_two]==1) )
                i_two--;
            swap(nums,i_zero,i_two);
            i_zero++;
            i_two--;
        }
      int i=0;
        while(i<nums.length&&nums[i]==0) i++;
        int i_one=i;i_two=nums.length-1;
        
        while(i_one<i_two){
            while(i_one<i_two&&i_one<nums.length&&nums[i_one]==1)
                i_one++;
            while(i_one<i_two&&i_two>i&&nums[i_two]==2 )
                i_two--;
           
            swap(nums,i_one,i_two);
            i_one++;
            i_two--;
        }
        
    }
    public void swap(int []nums, int i, int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length-1;
        int zero=0;
        int two=n;
        int i=0;
        for(;i<=two;i++){
            
            while(nums[i]==2&&i<two) {swap(nums,i,two);two--;}
             while(nums[i]==0&&i>zero) {swap(nums, i, zero);zero++;}
           
            
                            
        }
    }
    public void swap(int []nums, int i, int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    
    }
}
//learned:
