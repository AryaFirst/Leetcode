class Solution {
    public int countSubstrings(String s) {
       int res=0;
        for(int i=0;i<s.length();i++){
            for(int j=0;i-j>=0&&j+i<s.length()&&s.charAt(i-j)==s.charAt(i+j);j++)res++;
            for(int j=0;i-j-1>=0&&i+j<s.length()&&s.charAt(i-j-1)==s.charAt(i+j);j++) res++;
        }
        return res;
    }
}
