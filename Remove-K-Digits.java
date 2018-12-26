class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()==k) return"0"; 
        Stack<Character> st=new Stack<>();
        for(int i=0;i<num.length();i++){
            while(st.size()>0&&st.peek()>num.charAt(i)&&k>0)
            {st.pop();k--;}
          
            
                st.push(num.charAt(i));
            
        }
        while(k>0){
            st.pop();
            k--;
        }
        
        StringBuilder ss=new StringBuilder();
        // System.out.println(st.pop());
        while(st.size()>0){
            ss.append(st.pop());
        }
        
        ss.reverse();
       //System.out.println(ss);
        String res=ss.toString();
        int j=0;
        while(j<res.length()&&res.charAt(j)=='0'){
            j++;
        }
        if(j==res.length()) return "0";
        return res.substring(j,res.length());
    }
}
