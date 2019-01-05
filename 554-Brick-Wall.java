class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if(wall.size()==0) return 0;
       Map<Integer,Integer> map=new HashMap<>();
        int cnt=0;
        for(List<Integer> rol:wall){
           int sum=0;
            for(int i=0;i<rol.size()-1;i++){
                sum+=rol.get(i);
                map.put(sum,map.getOrDefault(sum,0)+1);
                cnt=Math.max(map.get(sum),cnt);
            }
        }
        
        return wall.size()-cnt;
    }
}
