class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res=new LinkedList<>();
        helper(res, new LinkedList<Integer>(), 0, nums);
        return res;
    }
    public void helper(List<List<Integer>> res, LinkedList<Integer> tmp, int index, int [] nums){
        if(tmp.size()>=2) res.add(new LinkedList<Integer>(tmp));
        Set<Integer> set=new HashSet<>();
        for(int i=index;i<nums.length;i++){
            if(set.contains(nums[i])) continue;
            if(tmp.size()==0||nums[i]>=tmp.peekLast()){
                tmp.add(nums[i]);
                set.add(nums[i]);
                helper(res, tmp, i+1, nums);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
