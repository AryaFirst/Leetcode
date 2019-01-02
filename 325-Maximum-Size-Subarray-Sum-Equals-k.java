class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int res=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum)==false)
                map.put(sum,i);
            int target=sum-k;
            if(map.containsKey(target))
                res=Math.max(res,i-map.get(target));
        }
        return res;
    }
}
