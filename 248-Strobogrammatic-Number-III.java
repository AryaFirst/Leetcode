class Solution {
    public int strobogrammaticInRange(String low, String high) {
      
        int cnt=0;
        List<String> rst=new ArrayList<>();
        for(int index=low.length();index<=high.length();index++){
           rst.addAll(helper(index,index));
           
        }
        for(String num:rst){
               
               if(num.length()==low.length()&&num.compareTo(low)<0||num.length()==high.length()&&num.compareTo(high)>0) continue;
              
               cnt++;
           }
        return cnt;
    }
    public List<String> helper(int i, int max){
        if(i==0) return new ArrayList<String>(Arrays.asList(""));
        if(i==1) return new ArrayList<String>(Arrays.asList("1","0","8"));
        List <String> center =helper(i-2, max);
        List<String> res=new ArrayList<String> ();
        for(int j=0;j<center.size();j++){
            String tmp=center.get(j);
            if(i!=max)
                res.add('0'+tmp+'0');
            res.add('1'+tmp+'1');
            res.add('6'+tmp+'9');
            res.add('9'+tmp+'6');
            res.add('8'+tmp+'8');
        }
        return res;
    }
}
