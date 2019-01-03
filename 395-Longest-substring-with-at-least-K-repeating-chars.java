class Solution {
    public int longestSubstring(String s, int k) {
        int i=0,j=0,unique=0,total=0,res=0,h=1;
        int []cnt=new int [26];
        for(;h<=26;h++){
            Arrays.fill(cnt,0);
            i=0;j=0;
            unique=0;
            total=0;
            while(j<s.length()){
                if(unique<=h){
                    char ch=s.charAt(j);
                    if(cnt[ch-'a']==0)
                        unique++;
                    cnt[ch-'a']++;
                    if(cnt[ch-'a']==k)
                        total++;
                    j++;
                }else {
                    char ch=s.charAt(i);
                    if(cnt[ch-'a']==1)
                        unique--;
                    cnt[ch-'a']--;
                    if(cnt[ch-'a']==k-1)
                        total--;
                    i++;
                }
                if(total==unique&&(j-i)>res)
                    res=j-i;
            }
        }
        return res;
    }
}
