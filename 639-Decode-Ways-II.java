class Solution {
    public int numDecodings(String s) {
        int M=1000000007;
        long [] dp=new long[s.length()+1];
        dp[0]=1;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                if(ch-'0'!=0)
                dp[i+1]=dp[i];
                if(i>=1)
                {
                    if(Character.isDigit(s.charAt(i-1))){
                        if(Integer.parseInt(s.substring(i-1,i+1))>=10&&Integer.parseInt(s.substring(i-1,i+1))<=26)
                            dp[i+1]=(dp[i+1]+dp[i-1])%M;
                        }
                    else{
                            if(ch-'0'>=0&&ch-'0'<=6)
                              dp[i+1]=(dp[i+1]+dp[i-1]*2)%M;
                            else 
                               dp[i+1]=(dp[i-1]+dp[i+1])%M;  
                           
                            }
                     }
            }else{
                    dp[i+1]=(dp[i]*9)%M;
            
                if(i>=1){
                    if(s.charAt(i-1)-'0'==1)
                         dp[i+1]=(dp[i-1]*9+dp[i+1])%M;
                    else if(s.charAt(i-1)-'0'==2)
                        dp[i+1]=(dp[i-1]*6+dp[i+1])%M;
                    else if(s.charAt(i-1)=='*')
                        dp[i+1]=(dp[i-1]*(15)+dp[i+1])%M;
                  
                    
                }
                
            
        }
        }
        return (int)dp[s.length()];
    }
}
