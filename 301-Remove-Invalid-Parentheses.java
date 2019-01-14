class Solution {
    public List<String> removeInvalidParentheses(String s) {
        if(s.length()==0||s==null) new LinkedList<>();
        List<String> res=new LinkedList<>();
        
        char [] p= {'(',')'};
        helper(res, 0 , 0, p, s);
        return res;
    }
    public void helper(List<String> res, int i, int j, char[]p, String s){
        int cnt=0;
        while(cnt>=0&&i<s.length()){
            char ch=s.charAt(i);
            if(ch==p[0]) cnt++;
            if(ch==p[1]) cnt--;
            i++;
        }

         if(i==s.length()&&cnt>=0){
           StringBuilder s2=new StringBuilder(s).reverse();
           String snew=s2.toString();
           if(p[0]==')')
               res.add(snew);
           else
               helper(res, 0, 0, new char[]{')','('}, snew);
           return;
           
       }
         i--;
        
        for(int cur=j; cur<=i; cur++){
            if(s.charAt(cur)==p[1]&& (cur==0||s.charAt(cur-1)!=p[1]))
            helper(res, i, cur, p, s.substring(0,cur)+s.substring(cur+1,s.length()));
        }
        
        return ;
      
        
    }
}
