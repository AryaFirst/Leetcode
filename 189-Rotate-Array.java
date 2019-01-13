class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        int count=0;
        for(int i=0;count <nums.length; i++){
            int current=i;
            int pre=nums[current];
            do{
                int tmp=pre;
                current=(current+k)%nums.length;
                pre=nums[current];
                nums[current]=tmp;
                count++;
                
                
                
            }while(current!=i);
        }
    }
}
