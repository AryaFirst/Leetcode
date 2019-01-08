class Solution {
   
   
    public List<String> findStrobogrammatic(int n) {
        return helper(n,n);
        
    }
    public List<String> helper(int n, int m){
       
        if(n==0) return new LinkedList<String> (Arrays.asList(""));
        else if (n==1) return new LinkedList<String> (Arrays.asList("1","0","8"));
         List<String> tmp=helper(n-2,m);
        List<String> res=new LinkedList<>();
        for(String s:tmp){
                if(n!=m)
             res.add("0"+s+"0");
             res.add("1"+s+"1");
             res.add("6"+s+"9");
             res.add("9"+s+"6");
             res.add("8"+s+"8");
        }
        
        
        return res;
    }
}
