class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int res=0;
        int j=0;//right pointer;
        int i=0;
        int cnt=0;
        Map<Character, Integer> map=new HashMap<>();
        
        while(j<s.length()){
            
            while(j<s.length()&&cnt<=k){
                char ch=s.charAt(j);
                if(!map.containsKey(ch))
                    map.put(ch,0);
              map.put(ch,map.get(ch)+1);
                if(map.get(ch)==1)
                    cnt++;
                
                j++;
               res=Math.max(res,j-i-1);
            }
            
            while(cnt>k){
                char ch=s.charAt(i);
                if(map.get(ch)>0) 
                    map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0)
                    cnt--;
                i++;
                
            }
            res=Math.max(res,j-i);
            
            
            
        }
        return res;
    }
}
