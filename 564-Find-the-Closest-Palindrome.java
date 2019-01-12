class Solution {
    public String nearestPalindromic(String n) {
        Long original=Long.parseLong(n);
        Long big=findBig(original+1);
        Long small=findSmall(original-1);
        return Math.abs(small-original)>Math.abs(big-original)? String.valueOf(big): String.valueOf(small);
    }
    public Long findBig( Long limit){
        String n=String.valueOf(limit);
        char []s=n.toCharArray();
        char []m=Arrays.copyOf(s,s.length);
        for(int index=0;index<m.length/2;index++){
            m[s.length-1-index]=m[index];
        }
        for(int i=0;i<s.length;i++){
            if(m[i]>s[i]){
                return Long.parseLong(String.valueOf(m));
            }else if(m[i]<s[i]){
                for(int index=(m.length-1)/2;index>=0;index--){
                    if(++m[index]<='9')
                        break;
                    else
                        m[index]='0';
                }
                 for(int index=0;index<m.length/2;index++){
                     m[s.length-1-index]=m[index];
                 }
                  return Long.parseLong(String.valueOf(m));
            }
        }
          return Long.parseLong(String.valueOf(m));
    }
    
    public Long findSmall(Long limit){
          String n=String.valueOf(limit);
          char []s=n.toCharArray();
          char []m=Arrays.copyOf(s,s.length);
        for(int index=0;index<m.length/2;index++){
            m[s.length-1-index]=m[index];
        }
        
        
         for(int i=0;i<s.length;i++){
            if(m[i]<s[i]){
                return Long.parseLong(String.valueOf(m));
            }else if(m[i]>s[i]){
                for(int index=(m.length-1)/2;index>=0;index--){
                    if(--m[index]>='0')
                        break;
                    else
                        m[index]='0';
                }
                if(m[0]=='0'){
                    char[] a=new char[m.length-1];
                    Arrays.fill(a,'9');
                    return Long.parseLong(String.valueOf(a));
                }
                 for(int index=0;index<m.length/2;index++){
                     m[s.length-1-index]=m[index];
                 }
                  return Long.parseLong(String.valueOf(m));
            }
        }
         return Long.parseLong(String.valueOf(m));
        
    }
}
